package org.nerdizin.eztrial.repositories;

import org.nerdizin.eztrial.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByEmail(String email);

	List<User> findByEmailAndFirstName(String email, String firstName);

}
