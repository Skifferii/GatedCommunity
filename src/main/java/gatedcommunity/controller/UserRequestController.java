package gatedcommunity.controller;

import gatedcommunity.model.dto.PropositionServiceDTO;
import gatedcommunity.model.dto.UserRequestDTO;
import gatedcommunity.service.interfaces.UserRequestService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-request")
@Tag(name = "UserRequest controller", description = "Controller for operations wis UserRequest")
public class UserRequestController  {

    private final UserRequestService userRequestService;

    public UserRequestController(UserRequestService userRequestService) {
        this.userRequestService = userRequestService;
    }

    public void attachPhoto(String photoUrl, String description) {

    }
    @PostMapping
    public UserRequestDTO saveUserRequest(UserRequestDTO userRequestDTO) {
        return userRequestService.saveUserRequest(userRequestDTO);
    }

        @GetMapping("/{id}")
    public UserRequestDTO getUserRequestById(
            @Parameter(description = "The id that needs to de fetch", required = true)
            @PathVariable("id") long id) {
        return userRequestService.getUserRequestById(id);
    }

    @GetMapping()
        public List<UserRequestDTO> getAllUserRequest() {
        return userRequestService.getAllUserRequest();
    }

    public UserRequestDTO updateUserRequest(Long id, UserRequestDTO userRequestDTO) {
        return userRequestService.updateUserRequest(id, userRequestDTO);
    }


    public UserRequestDTO deleteUserRequestById(Long id) {
        return userRequestService.deleteUserRequestById(id);
    }


    public UserRequestDTO restoreUserRequestById(Long id) {
        return userRequestService.restoreUserRequestById(id);
    }


    public UserRequestDTO removeUserRequestById(Long id) {
        return userRequestService.removeUserRequestById(id);
    }
}
