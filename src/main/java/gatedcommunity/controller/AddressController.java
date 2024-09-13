package gatedcommunity.controller;

import gatedcommunity.model.dto.AddressDTO;
import gatedcommunity.model.entity.Address;
import gatedcommunity.service.interfaces.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {


    @PostMapping
    public AddressDTO saveAddress(@RequestBody AddressDTO addressDTO) {
        return null;
    }

    @GetMapping("/{id}")
    AddressDTO getAddressById( long id) {
        return null;
    };

    @PutMapping("/{id}")
    public AddressDTO updateAddressById(@PathVariable Long id, @RequestBody AddressDTO addressDTO) {
        return null;
    }

    @GetMapping
    public List<AddressDTO> getAllAddress() {
        return null;
    }

    @DeleteMapping
    public AddressDTO deleteAddressById(Long id) {
        return null;
    }

}
