package projectfs44.gatedcommunity.service.interfaces;

<<<<<<< HEAD:src/main/java/gatedcommunity/service/interfaces/UserService.java
import gatedcommunity.model.dto.UserDTO;
import gatedcommunity.model.dto.UserRegisterDTO;
import gatedcommunity.model.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
=======
import projectfs44.gatedcommunity.model.dto.UserDTO;
import projectfs44.gatedcommunity.model.dto.UserRegisterDTO;
>>>>>>> origin/dev:src/main/java/projectfs44/gatedcommunity/service/interfaces/UserService.java
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService  {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    void register(UserRegisterDTO registerDto);
    String confirmationMailByCode(String code);


    UserDTO saveUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(long id);
    UserDTO getUserByName(String name);
    UserDTO updateUser(Long id, UserDTO userDTO);
    UserDTO deleteUserById(Long id);
    UserDTO restoreUserById(Long id);
    UserDTO removeUserById(Long id);

 }
