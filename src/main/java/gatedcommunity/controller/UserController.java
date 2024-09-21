package gatedcommunity.controller;


import gatedcommunity.model.dto.UserRegisterDTO;
import gatedcommunity.model.entity.User;
import gatedcommunity.service.interfaces.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping
//    public User save(@RequestBody User user) {
//        return userService.save(user);
//    }
//
//    @GetMapping
//    public List<User> getAllActiveUsers() {
//        return userService.getAllActiveUsers();
//    }
//
//    @GetMapping("/{id}")
//    public User getById(@PathVariable long id) {
//        return userService.getById(id);
//    }
//
//    @PutMapping
//    public User update(@RequestBody User user) {
//        return userService.update(user);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteById(@PathVariable long id) {
//        userService.deleteById(id);
//    }
//
//    @DeleteMapping
//    public void deleteByUsername(@RequestParam String username) {
//        userService.deleteByUsername(username);
//
//    }
//
//    @PutMapping("/restore/{id}")
//    public void restoreById(long id) {
//        userService.restoreById(id);
//
//    }
//
//    @GetMapping
//    public long getActiveUserCount() {
//        return userService.getActiveUserCount();
//    }
//
}


