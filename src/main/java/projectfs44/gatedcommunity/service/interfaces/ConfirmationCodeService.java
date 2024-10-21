package projectfs44.gatedcommunity.service.interfaces;

<<<<<<< HEAD:src/main/java/gatedcommunity/service/interfaces/ConfirmationCodeService.java
=======
import projectfs44.gatedcommunity.model.entity.ConfirmationCode;
import projectfs44.gatedcommunity.model.entity.User;

import java.util.Optional;

>>>>>>> origin/dev:src/main/java/projectfs44/gatedcommunity/service/interfaces/ConfirmationCodeService.java
public interface ConfirmationCodeService {
    String generationConfirmationCode(User user);

    Optional<ConfirmationCode> findCodeByUser(User user);

    void remove(ConfirmationCode code);

    Optional<ConfirmationCode> findByCode(String code);
}
