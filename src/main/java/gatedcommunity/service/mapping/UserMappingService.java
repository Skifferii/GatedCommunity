package gatedcommunity.service.mapping;


import gatedcommunity.model.dto.UserDTO;
import gatedcommunity.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMappingService {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    User mapDTOToEntity(UserDTO userDTO);
    UserDTO mapEntityToDTO(User entity);
}
