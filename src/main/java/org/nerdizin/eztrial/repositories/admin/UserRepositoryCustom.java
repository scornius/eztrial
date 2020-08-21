package org.nerdizin.eztrial.repositories.admin;

import org.nerdizin.eztrial.entities.admin.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepositoryCustom {

    Page<User> findAll(Pageable pageable, UserFilter userFilter);

    long countAll(UserFilter userFilter);
}
