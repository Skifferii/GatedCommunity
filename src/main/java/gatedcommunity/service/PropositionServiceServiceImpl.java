package gatedcommunity.service;

import gatedcommunity.exception_handling.exceptions.FirstTestException;
import gatedcommunity.exception_handling.exceptions.ThirdTestException;
import gatedcommunity.model.dto.PropositionServiceDTO;
import gatedcommunity.model.entity.PropositionService;
import gatedcommunity.repository.PropositionServiceRepository;
import gatedcommunity.service.interfaces.PropositionServiceService;
import gatedcommunity.service.mapping.PropositionServiceMappingService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropositionServiceServiceImpl implements PropositionServiceService {

    private final PropositionServiceRepository repository;
    private final PropositionServiceMappingService mapper;

    public PropositionServiceServiceImpl(PropositionServiceRepository repository, PropositionServiceMappingService mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public void attachImage(String imageUrl, String productTitle) {

    }

    @Override
    public PropositionServiceDTO savePropositionService(PropositionServiceDTO propositionServiceDTO) {
        PropositionService propositionService = mapper.mapDtoToEntity(propositionServiceDTO);
        propositionService.setActive(true);
        return mapper.mapEntityToDto(repository.save(propositionService));
    }

    @Override
    public PropositionServiceDTO getById(long id) {
        PropositionService propositionService = repository.findById(id).orElse(null);

        if (propositionService == null ){
            throw  new ThirdTestException("Product with id" + id + " not found");
        }
        if (!propositionService.isActive()){
            throw new FirstTestException("This is first Test Exception message");
        }

        return mapper.mapEntityToDto(propositionService);
    }

    @Override
    public PropositionServiceDTO getByTitle(String title) {
        return null;
    }

    @Override
    public List<PropositionServiceDTO> getAllPropositionService() {
        return List.of();
    }

    @Override
    public PropositionServiceDTO updatePropositionService(Long id, PropositionServiceDTO propositionServiceDTO) {
        return null;
    }

    @Override
    public PropositionServiceDTO deleteById(Long id) {
        return null;
    }
}
