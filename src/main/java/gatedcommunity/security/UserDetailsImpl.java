package gatedcommunity.security;

import gatedcommunity.model.dto.UserRegisterDto;
import gatedcommunity.repository.UserRepository;
import gatedcommunity.service.interfaces.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsImpl implements UserService {

    private final UserRepository userRepository;

    public UserDetailsImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUserName(username).orElseThrow(
                () -> new UsernameNotFoundException(username));
    }

    @Override
    public void register(UserRegisterDto registerDto) {

    }

    @Override
    public String confirmationMailByCode(String code) {
        return "";
    }
}
