package gatedcommunity.service.mapping;

import gatedcommunity.model.dto.UserRequestDTO;
import gatedcommunity.model.entity.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRequestMappingService {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    @Mapping(target = "photo", ignore = true)
   UserRequest mapDTOToEntity(UserRequestDTO userRequestDTO);
   UserRequestDTO mapEntityToDTO(UserRequest entity);


}
