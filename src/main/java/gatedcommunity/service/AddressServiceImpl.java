package gatedcommunity.service;

import gatedcommunity.exception_handling.exceptions.FirstTestException;
import gatedcommunity.exception_handling.exceptions.ThirdTestException;
import gatedcommunity.model.dto.AddressDTO;
import gatedcommunity.model.entity.Address;
import gatedcommunity.repository.AddressRepository;
import gatedcommunity.service.interfaces.AddressService;
import gatedcommunity.service.mapping.AddressMappingService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMappingService addressMappingService;

    public AddressServiceImpl(AddressRepository addressRepository, AddressMappingService addressMappingService) {
        this.addressRepository = addressRepository;
        this.addressMappingService = addressMappingService;
    }


    @Override
    public AddressDTO saveAddress(AddressDTO addressDTO) {
        Address address = addressMappingService.mapDtoToEntity(addressDTO);
        address.setActive(true);
        return addressMappingService.mapEntityToDto(addressRepository.save(address));
    }

    @Override
    public AddressDTO getAddressById(long id) {
        /*Address address = addressRepository.findAddressById(id);

        if (address == null) {

            throw new ThirdTestException("Address with id " + id + " not found");
        }
        if (address.isActive()) {
            throw new FirstTestException("This is first test Exception message");
        }
        return addressMappingService.mapEntityToDto(address);*/
        return null;
    }

    @Override
    public List<AddressDTO> getAllAddress() {

        return addressRepository.findAll().stream()
                .filter(Address::isActive)
                .map(addressMappingService::mapEntityToDto)
                .toList();

    }

    @Override
    public AddressDTO updateAddressById(Long id, AddressDTO addressDTO) {

        return null;
    }

    @Override
    public AddressDTO deleteAddressById(Long id) {

        return null;
    }
}
