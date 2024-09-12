package gatedcommunity.service.interfaces;

import gatedcommunity.model.dto.UserRegisterDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService  {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    void register(UserRegisterDTO registerDto);
    String confirmationMailByCode(String code);
}