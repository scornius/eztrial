package org.nerdizin.eztrial.repositories.admin;

import org.nerdizin.eztrial.entities.admin.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {

	Iterable<User> findAllByOrderByOid();

	Optional<User> findByUserName(String userName);

	Optional<User> findByEmail(String email);

	@Query("SELECT u FROM User u LEFT JOIN FETCH u.roles r LEFT JOIN FETCH r.privileges WHERE u.userName = :userNameOrEmail or u.email = :userNameOrEmail")
	Optional<User> findByUserNameOrEmailAndEagerlyFetchRoles(@Param("userNameOrEmail") String userNameOrEmail);

	@Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.id = :id")
	Optional<User> findByIdAndEagerlyFetchRoles(@Param("id") Long id);

}
