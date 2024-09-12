package gatedcommunity.service.interfaces;

import gatedcommunity.model.dto.PropositionServiceDTO;

import java.util.List;

public interface PropositionServiceService {

    void attachImage(String imageUrl, String productTitle);

    PropositionServiceDTO savePropositionService(PropositionServiceDTO propositionServiceDTO);

    PropositionServiceDTO getById(long id);

    List<PropositionServiceDTO>  getByTitle(String title);

    List<PropositionServiceDTO> getAllPropositionService();

    PropositionServiceDTO updatePropositionService(Long id, PropositionServiceDTO propositionServiceDTO);

    PropositionServiceDTO deleteById(Long id);

    PropositionServiceDTO restoreById(Long id);


}
