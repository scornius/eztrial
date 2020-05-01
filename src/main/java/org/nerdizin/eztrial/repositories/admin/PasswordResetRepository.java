package org.nerdizin.eztrial.repositories.admin;

import org.nerdizin.eztrial.entities.admin.PasswordReset;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PasswordResetRepository extends CrudRepository<PasswordReset,Long> {

    @Query("select p from PasswordReset p where p.accessToken = :accessToken " +
            "and p.usedDate is null")
    Optional<PasswordReset> findByAccessTokenAndValid(@Param("accessToken") String accessToken);

}
