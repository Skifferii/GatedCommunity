package gatedcommunity.controller;

import gatedcommunity.model.entity.Address;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @PostMapping
    public Address saveAddress(@RequestBody Address address) {
        return address;
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable long id) {
        return null;
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable long id, @RequestBody Address address) {
        return address;
    }


    @GetMapping
    public List<Address> getAllAddress() {
        return null;
    }

}
