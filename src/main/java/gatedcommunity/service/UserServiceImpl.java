package gatedcommunity.service;

import gatedcommunity.model.dto.UserRegisterDTO;
import gatedcommunity.service.interfaces.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements UserService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public void register(UserRegisterDTO registerDto) {

    }

    @Override
    public String confirmationMailByCode(String code) {
        return "";
    }
}
