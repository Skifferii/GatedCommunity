package gatedcommunity.controller;

import gatedcommunity.model.dto.PropositionServiceDTO;
import gatedcommunity.service.interfaces.PropositionServiceService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/proposition-service")
@Tag(name = "PropositionService controller", description = "Controller for operations wis PropositionService")
public class PropositionServiceController {

    private final PropositionServiceService propositionServiceService;


    public PropositionServiceController(PropositionServiceService propositionServiceService) {
        this.propositionServiceService = propositionServiceService;
    }

    @PostMapping
    public PropositionServiceDTO saveProduct(@Valid @RequestBody PropositionServiceDTO propositionServiceDTO){
        //  обращаемся к сервису для сохранения сервиса
        return propositionServiceService.savePropositionService(propositionServiceDTO);
    }

    @GetMapping("/{id}")
    public PropositionServiceDTO getById(
            @Parameter(description = "The id that needs to de fetche", required = true) @PathVariable("id") long id){

        //  обращаемся к сервису для получения сервиса по id
        return propositionServiceService.getById(id);
    }

    @GetMapping("/{title}")
    public PropositionServiceDTO getByTitle(
            @Parameter(description = "The id that needs to de fetche", required = true) @PathVariable("title") String title){

        //  обращаемся к сервису для получения сервиса по id
        return propositionServiceService.getByTitle(title);
    }
}
