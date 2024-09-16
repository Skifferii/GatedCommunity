package gatedcommunity.service.interfaces;

import gatedcommunity.model.dto.PropositionServiceDTO;

import java.util.List;

public interface PropositionServiceService {

    void attachImage(String imageUrl, String productTitle);

    PropositionServiceDTO savePropositionService(PropositionServiceDTO propositionServiceDTO);

    PropositionServiceDTO getPropositionServiceById(long id);

    List<PropositionServiceDTO> getPropositionServiceByTitle(String title);

    List<PropositionServiceDTO> getAllPropositionService();

    PropositionServiceDTO updatePropositionService(Long id, PropositionServiceDTO propositionServiceDTO);

    PropositionServiceDTO deletePropositionServiceById(Long id);

    PropositionServiceDTO restorePropositionServiceById(Long id);


}
