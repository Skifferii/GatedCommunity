package gatedcommunity.controller;

import gatedcommunity.model.dto.PropositionServiceDTO;
import gatedcommunity.service.interfaces.PropositionServiceService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/offered-services")
@Tag(name = "PropositionService controller", description = "Controller for operations wis PropositionService")
public class PropositionServiceController {

    private final PropositionServiceService propositionServiceService;


    public PropositionServiceController(PropositionServiceService propositionServiceService) {
        this.propositionServiceService = propositionServiceService;
    }


    public void attachImage(String imageUrl, String productTitle) {

    }

    @PostMapping
    public PropositionServiceDTO savePropositionService(@Valid @RequestBody PropositionServiceDTO propositionServiceDTO){
        //  обращаемся к сервису для сохранения сервиса
        return propositionServiceService.savePropositionService(propositionServiceDTO);
    }

    @GetMapping("/{id}")
    public PropositionServiceDTO getPropositionServiceById(
            @Parameter(description = "The id that needs to de fetch", required = true) @PathVariable("id") long id){

        //  обращаемся к сервису для получения сервиса по id
        return propositionServiceService.getPropositionServiceById(id);
    }

    @GetMapping()
    public List<PropositionServiceDTO> getPropositionServiceAllOrByTitle(@RequestParam(required = false) String title){
        if (title != null) {
            return propositionServiceService.getPropositionServiceByTitle(title);
        } else {
            return propositionServiceService.getAllPropositionService();
        }
    }

//    @GetMapping
//    public List<PropositionServiceDTO> getPropositionServiceByTitle(
//            @Parameter(description = "The title that needs to de fetch", required = true) @RequestParam String title){ // /offered-services?title=LightBulb
//
//        //  обращаемся к сервису для получения сервиса по title
//        return propositionServiceService.getPropositionServiceByTitle(title);
//    }
//
//    @GetMapping("/all")
//    public List<PropositionServiceDTO> getAllPropositionService(){
//        return propositionServiceService.getAllPropositionService();
//    }

    @PutMapping("/{id}")
    public PropositionServiceDTO updatePropositionService(Long id, @RequestBody PropositionServiceDTO propositionServiceDTO){
        return propositionServiceService.updatePropositionService(id, propositionServiceDTO);
    }

    // DELETE /offered-services/2
    @DeleteMapping("/{id}")
    public PropositionServiceDTO deletePropositionServiceById(@PathVariable Long id){
        return propositionServiceService.deletePropositionServiceById(id);
    }

    // PUT /offered-services/restore/2
    @PutMapping("/restore/{id}")
    public PropositionServiceDTO restorePropositionServiceById(@PathVariable Long id) {
        return propositionServiceService.restorePropositionServiceById(id);
    }
}
