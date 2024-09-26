package gatedcommunity.service;

import gatedcommunity.model.dto.UserDTO;
import gatedcommunity.model.dto.UserRegisterDTO;
import gatedcommunity.model.entity.User;
import gatedcommunity.repository.UserRepository;
import gatedcommunity.service.interfaces.UserService;
import gatedcommunity.service.mapping.UserMappingService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMappingService mapper;

    public UserServiceImpl(UserRepository repository, UserMappingService mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findUserByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    @Override
    public void register(UserRegisterDTO registerDTO) {
        User user = mapper.mapRegisterDTOToEntity(registerDTO);
        user.setActive(true); // или false, в зависимости от логики
        repository.save(user);
    }

    @Override
    public String confirmationMailByCode(String code) {
        return "Email successfully confirmed!";
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = mapper.mapDTOToEntity(userDTO);
        user.setActive(true);
        return mapper.mapEntityToDTO(repository.save(user));

    }

    @Override
    public List<UserDTO> getAllUsers() {
        return repository.findAll().stream()
                .map(mapper::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(long id) {
        return repository.findById(id)
                .map(mapper::mapEntityToDTO)
                .orElseThrow(() -> new RuntimeException("The user with the ID was not found: " + id));
    }

    @Override
    public UserDTO getUserByName(String name) {
        return repository.findUserByUserName(name)
                .map(mapper::mapEntityToDTO)
                .orElseThrow(() -> new RuntimeException("User not found: " + name));
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));

        mapper.mapDTOToEntityUpdate(userDTO, user);
        user.setActive(true);
        return mapper.mapEntityToDTO(repository.save(user));
    }

    @Override
    public UserDTO deleteUserById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));

        repository.deleteById(id);
        return mapper.mapEntityToDTO(user);
    }

    @Override
    public UserDTO restoreUserById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));

        user.setActive(true);
        return mapper.mapEntityToDTO(repository.save(user));
    }

    @Override
    public UserDTO removeUserById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found: " + id));
        user.setActive(false);
        return mapper.mapEntityToDTO(repository.save(user));

    }

}
