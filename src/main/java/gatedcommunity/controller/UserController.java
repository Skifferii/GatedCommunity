package gatedcommunity.controller;


import gatedcommunity.model.dto.UserDTO;
import gatedcommunity.service.interfaces.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

//    @GetMapping("/{id}")
//    public UserDTO getUserById(@PathVariable long id) {
//        return userService.getUserById(id);
//    }
//
//    @GetMapping
//    public UserDTO getUserByName(String name) {
//        return null;
//    }


    //  Get /users?id=1&title=Banana
    @GetMapping
    public UserDTO getUserByIdOrByName(@RequestParam(required = false) Long id,
                                       @RequestParam(required = false) String name) {
        if (id != null) {
            return userService.getUserById(id);
        } else if (name != null) {
            return userService.getUserByName(name);
        }
            return null;
    }


    @PutMapping("/update/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/{id}")
    public UserDTO deleteUserById(@PathVariable Long id) {
        return userService.deleteUserById(id);
    }

    @PutMapping("/restore/{id}")
    public UserDTO restoreUserById(@PathVariable Long id) {
        return userService.restoreUserById(id);
    }

    @PutMapping("/remove/{id}")
    public UserDTO removeUserById(@PathVariable Long id) {
        return userService.removeUserById(id);
    }
}


