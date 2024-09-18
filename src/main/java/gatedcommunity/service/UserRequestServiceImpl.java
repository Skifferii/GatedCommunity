package gatedcommunity.service;

import gatedcommunity.exception_handling.exceptions.TextException;
import gatedcommunity.model.dto.UserRequestDTO;
import gatedcommunity.model.entity.UserRequest;
import gatedcommunity.repository.UserRequestRepository;
import gatedcommunity.service.interfaces.UserRequestService;
import gatedcommunity.service.mapping.UserRequestMappingService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRequestServiceImpl implements UserRequestService {

    private final UserRequestRepository repository;
    private final UserRequestMappingService mapper;

    public UserRequestServiceImpl(UserRequestRepository repository, UserRequestMappingService mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public void attachPhoto(String photoUrl, String description) {
    }

    @Override
    public UserRequestDTO saveUserRequest(UserRequestDTO userRequestDTO) {
        UserRequest userRequest = mapper.mapDTOToEntity(userRequestDTO);
        userRequest.setActive(true);
        return mapper.mapEntityToDTO(repository.save(userRequest));
    }

    @Override
    public UserRequestDTO getUserRequestById(long id) {
        UserRequest userRequest = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User request not found for id: " + id));

        if (!userRequest.isActive()) {
            throw new TextException("User request with id " + id + " is not active");
        }
        return mapper.mapEntityToDTO(userRequest);
    }

    @Override
    public List<UserRequestDTO> getAllUserRequest() {
        return repository.findAll().stream()
                .filter(UserRequest::isActive)
                .map(mapper::mapEntityToDTO)
                .toList();
    }

    @Override
    public UserRequestDTO deleteUserRequestById(Long id) {
        UserRequest userRequest = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User request not found for id: " + id));

        repository.deleteById(id);
        return mapper.mapEntityToDTO(userRequest);
    }

    @Override
    public UserRequestDTO restoreUserRequestById(Long id) {
        UserRequest userRequest = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User request not found for id: " + id));

        userRequest.setActive(true);
        return mapper.mapEntityToDTO(repository.save(userRequest));
    }

    @Override
    public UserRequestDTO removeUserRequestById(Long id) {
        UserRequest userRequest = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User request not found for id: " + id));

        userRequest.setActive(false);
        return mapper.mapEntityToDTO(repository.save(userRequest));
    }

    @Override
    public UserRequestDTO updateUserRequest(Long id, UserRequestDTO userRequestDTO) {

        UserRequest userRequest = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User request not found for id: " + id));

        mapper.mapDTOToEntityUpdate(userRequestDTO, userRequest);  // Use mapper for update Entity

        userRequest.setActive(true);

        return mapper.mapEntityToDTO(repository.save(userRequest));

        //        UserRequest userRequest = repository.findById(id)
//        .orElseThrow(() -> new EntityNotFoundException("User request not found for id: " + id));//
//            mapper.mapDTOToEntity(userRequestDTO);
//            userRequest.setUserId(userRequestDTO.getUserId());
//            userRequest.setDescription(userRequestDTO.getDescription());
//            userRequest.setAddressId(userRequestDTO.getAddressId());
//            userRequest.setPropositionServiceId(userRequestDTO.getPropositionServiceId());
//            userRequest.setDesiredDateTime(userRequestDTO.getDesiredDateTime());
//            userRequest.setPhoto(userRequestDTO.getPhoto());
//            userRequest.setActive(true);
//            return mapper.mapEntityToDTO(repository.save(userRequest));
//
    }
}
