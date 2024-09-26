package gatedcommunity.controller;

import gatedcommunity.model.dto.UserRequestDTO;
import gatedcommunity.model.dto.UserResponseDTO;

import gatedcommunity.model.entity.PropositionService;
import gatedcommunity.service.interfaces.PropositionServiceService;
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

    private final PropositionServiceService propositionService;
    private final UserRequestService userRequestService;

    public UserRequestController(UserRequestService userRequestService, PropositionServiceService propositionService) {
        this.userRequestService = userRequestService;
        this.propositionService = propositionService;
    }

    public void attachPhoto(String picture, String description) {

    }

    @PostMapping
    public UserRequestDTO saveUserRequest(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        return userRequestService.saveUserRequest(userRequestDTO);
    }

    @GetMapping("/{id}")
    public UserRequestDTO getUserRequestById(
            @Parameter(description = "The ID of the user request to fetch", required = true)
            @PathVariable("id") long id) {
        return userRequestService.getUserRequestById(id);
    }

//    @GetMapping
//    public List<UserRequestDTO> getAllUserRequests() {
//        return   userRequestService.getAllUserRequest();}

    @GetMapping
    public List<UserResponseDTO> getAllUserRequests() {
        List<UserRequestDTO> userRequestDTOList = userRequestService.getAllUserRequest();
        return userRequestDTOList.stream()
                .map(userRequestDTO -> {
                    UserResponseDTO userResponseDTO = new UserResponseDTO();
                    userResponseDTO.setId(userRequestDTO.getId());
                    userResponseDTO.setDescription(userRequestDTO.getDescription());
                    userResponseDTO.setActive(userRequestDTO.isActive());
                    userResponseDTO.setAddressId(userRequestDTO.getAddressId());
                    userResponseDTO.setDesiredDateTime(userRequestDTO.getDesiredDateTime());
                    userResponseDTO.setUserId(userRequestDTO.getUserId());
                    userResponseDTO.setPropositionServiceId(userRequestDTO.getPropositionServiceId());
                    String propositionServiceTitle = propositionService.getPropositionServiceById(userRequestDTO.getPropositionServiceId()).getTitle();
                    userResponseDTO.setPropositionServiceTitle(propositionServiceTitle);
                    return userResponseDTO;
                })
                .toList();

    }


    @PutMapping("/{id}")
    public UserRequestDTO updateUserRequest(
            @PathVariable("id") Long id,
            @Valid @RequestBody UserRequestDTO userRequestDTO) {
        return userRequestService.updateUserRequest(id, userRequestDTO);
    }

    @DeleteMapping("/{id}")
    public UserRequestDTO deleteUserRequestById(@PathVariable("id") Long id) {
        return userRequestService.deleteUserRequestById(id);
    }

    @PatchMapping("/restore/{id}")
    public UserRequestDTO restoreUserRequestById(@PathVariable("id") Long id) {
        return userRequestService.restoreUserRequestById(id);
    }

    @DeleteMapping("/remove/{id}")
    public UserRequestDTO removeUserRequestById(@PathVariable("id") Long id) {
        return userRequestService.removeUserRequestById(id);
    }
}



