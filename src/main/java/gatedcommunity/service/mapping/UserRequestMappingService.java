package gatedcommunity.service.mapping;

import gatedcommunity.model.dto.UserRequestDTO;
import gatedcommunity.model.entity.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserRequestMappingService {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    UserRequest mapDTOToEntity(UserRequestDTO userRequestDTO);
    UserRequestDTO mapEntityToDTO(UserRequest entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    void mapDTOToEntityUpdate(UserRequestDTO userRequestDTO, @MappingTarget UserRequest userRequest);  // Use @MappingTarget for update Entity


}