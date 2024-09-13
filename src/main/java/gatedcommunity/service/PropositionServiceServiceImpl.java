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
            throw  new ThirdTestException("Proposition service with id" + id + " not found");
        }
        if (!propositionService.isActive()){
            throw new FirstTestException("This is first Test Exception message");
        }

        return mapper.mapEntityToDto(propositionService);
    }

    @Override
    public List<PropositionServiceDTO> getByTitle(String title) {
        return repository.findPropositionServiceByTitle(title).stream()
                .filter(PropositionService::isActive)
                .map(mapper::mapEntityToDto)
                .toList();
    }

    @Override
    public List<PropositionServiceDTO> getAllPropositionService() {
        System.out.println("test");
        return repository.findAll().stream()
                // фильтруем
                .filter(PropositionService::isActive)
                // превращаем элемент стрима из Product в стрим ProductDTO
                .map(mapper::mapEntityToDto)
                // собираем обратно в список
                .toList();
    }

    @Override
    public PropositionServiceDTO updatePropositionService(Long id, PropositionServiceDTO propositionServiceDTO) {
        return null;
    }

    @Override
    public PropositionServiceDTO deleteById(Long id) {
        return null;
    }

    @Override
    public PropositionServiceDTO restoreById(Long id) {
        return null;
    }


}
