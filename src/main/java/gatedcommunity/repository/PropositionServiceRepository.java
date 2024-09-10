package gatedcommunity.repository;

import gatedcommunity.model.entity.PropositionService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PropositionServiceRepository extends JpaRepository<PropositionService, Long> {


    Optional<PropositionService> findPropositionServiceByTitle(String title);
}






//public interface ProductRepository extends JpaRepository<Product, Long> {
//
//
//    List<Product> findAllByActiveTrue();
//    Optional<Product> findByTitle(String title);
//    //    List<Product> findAllByActive(boolean active);
//}