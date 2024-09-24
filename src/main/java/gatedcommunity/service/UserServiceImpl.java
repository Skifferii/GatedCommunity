package gatedcommunity.service;

import gatedcommunity.model.dto.UserRegisterDTO;
import gatedcommunity.model.entity.User;
import gatedcommunity.service.interfaces.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public List<User> getAllActiveUsers() {
        return List.of();
    }

    @Override
    public User getById(long id) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void deleteByUsername(String username) {

    }

    @Override
    public void restoreById(long id) {

    }

    @Override
    public long getActiveUserCount() {
        return 0;
    }
}
