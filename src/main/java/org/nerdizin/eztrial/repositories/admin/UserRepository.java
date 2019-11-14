package org.nerdizin.eztrial.repositories.admin;

import org.nerdizin.eztrial.entities.admin.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	Iterable<User> findAllByOrderByOid();

	@Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.userName = :userName")
	Optional<User> findByUserNameAndEagerlyFetchRoles(@Param("userName") String userName);

	@Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.id = :id")
	Optional<User> findByIdAndEagerlyFetchRoles(@Param("id") Long id);
}
