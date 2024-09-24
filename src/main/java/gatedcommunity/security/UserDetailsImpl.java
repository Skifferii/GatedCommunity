package gatedcommunity.security;

import gatedcommunity.model.dto.UserRegisterDTO;
import gatedcommunity.repository.UserRepository;
import gatedcommunity.service.interfaces.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
public class UserDetailsImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.findUserByUserName(username).orElseThrow(
//                () -> new UsernameNotFoundException(username));
//    }
//
//    @Override
//    public void register(UserRegisterDTO registerDto) {
//
//    }
//
//    @Override
//    public String confirmationMailByCode(String code) {
//        return "";
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
