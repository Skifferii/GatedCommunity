package gatedcommunity.service.mapping;

import gatedcommunity.model.dto.PropositionServiceDTO;
import gatedcommunity.model.entity.PropositionService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PropositionServiceMappingService {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    @Mapping(target = "image", ignore = true)
    PropositionService mapDtoToEntity(PropositionServiceDTO dto);

    PropositionServiceDTO mapEntityToDto(PropositionService entity);


}






