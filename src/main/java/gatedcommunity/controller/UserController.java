package gatedcommunity.controller;


import gatedcommunity.model.dto.UserDTO;
//import gatedcommunity.service.interfaces.UserService;
import gatedcommunity.service.interfaces.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/{id}")
    public UserDTO getUserById(
            @Parameter(description = "The id that needs to de fetch", required = true) @PathVariable("id") long id){

        return userService.getUserById(id);
    }

    @GetMapping("/resoult{name}")
    public UserDTO getUserAllOrByTitle(@RequestParam(required = false) String name){
        if (name != null) {
            return userService.getUserByName(name).get(0);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
        }
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


