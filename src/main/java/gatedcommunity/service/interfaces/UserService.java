package gatedcommunity.service.interfaces;

import gatedcommunity.model.dto.UserRegisterDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService  {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    void register(UserRegisterDto registerDto);
    String confirmationMailByCode(String code);
}