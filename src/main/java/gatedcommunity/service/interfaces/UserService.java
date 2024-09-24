package gatedcommunity.service.interfaces;

import gatedcommunity.model.dto.UserRegisterDTO;
import gatedcommunity.model.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService  {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    void register(UserRegisterDTO registerDto);
    String confirmationMailByCode(String code);


    User save(User user);
    List<User> getAllActiveUsers();
    User getById(long id);
    User update(User user);
    void deleteById(long id);
    void deleteByUsername(String username);
    void restoreById(long id);
    long getActiveUserCount();
 }
