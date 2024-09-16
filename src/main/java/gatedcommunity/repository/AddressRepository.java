package gatedcommunity.repository;

import gatedcommunity.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {


//    List<Address> findAddressById (long id);
//   /* List<Address> findAddress(Long id);*/
}
