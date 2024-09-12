package gatedcommunity.service;

import gatedcommunity.model.dto.AddressDTO;
import gatedcommunity.service.interfaces.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    @Override
    public AddressDTO saveAddress(AddressDTO addressDTO) {
        return null;
    }

    @Override
    public AddressDTO getAddressById(long id) {
        return null;
    }

    @Override
    public AddressDTO updateAddressById(Long id, AddressDTO addressDTO) {
        return null;
    }

    @Override
    public List<AddressDTO> getAllAddress() {
        return List.of();
    }

    @Override
    public AddressDTO deleteAddressById(Long id) {
        return null;
    }
}
