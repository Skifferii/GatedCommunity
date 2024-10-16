package projectfs44.gatedcommunity.repository;

<<<<<<< HEAD:src/main/java/gatedcommunity/repository/UserRepository.java
import aj.org.objectweb.asm.commons.Remapper;
import gatedcommunity.model.entity.User ;
=======
import projectfs44.gatedcommunity.model.entity.User;
>>>>>>> origin/dev:src/main/java/projectfs44/gatedcommunity/repository/UserRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUserName(String userName);
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);


}