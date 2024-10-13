package projectfs44.gatedcommunity.service.mapping;

<<<<<<< HEAD:src/main/java/gatedcommunity/service/mapping/UserRequestMappingService.java
import gatedcommunity.model.dto.UserRequestDTO;
import gatedcommunity.model.entity.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
=======
import projectfs44.gatedcommunity.model.dto.UserRequestDTO;
import projectfs44.gatedcommunity.model.entity.UserRequest;
import projectfs44.gatedcommunity.service.interfaces.PropositionServiceService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> origin/dev:src/main/java/projectfs44/gatedcommunity/service/mapping/UserRequestMappingService.java

@Mapper(componentModel = "spring")
public interface UserRequestMappingService {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    @Mapping(target = "photo", ignore = true)
   UserRequest mapDTOToEntity(UserRequestDTO userRequestDTO);
   UserRequestDTO mapEntityToDTO(UserRequest entity);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    void mapDTOToEntityUpdate(UserRequestDTO userRequestDTO, @MappingTarget UserRequest userRequest);  // Use @MappingTarget for update Entity
}
