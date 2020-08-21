package org.nerdizin.eztrial.repositories.admin;

import org.nerdizin.eztrial.entities.admin.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User, Long>,
		JpaSpecificationExecutor<User>, UserRepositoryCustom {

	@Query("SELECT u FROM User u WHERE u.deleted = false ORDER BY u.oid")
	Iterable<User> findAllByOrderByOid();

	@Query("SELECT u FROM User u LEFT JOIN FETCH u.roles r LEFT JOIN FETCH r.privileges WHERE u.deleted = false ORDER BY u.oid")
	Iterable<User> findAllEagerlyFetchRoles();

	@Query("SELECT u FROM User u WHERE u.deleted = false AND u.id = :id")
	Optional<User> findById(@Param("id") Long id);

	@Query("SELECT u FROM User u " +
			"WHERE (u.userName = :userNameOrEmail or u.email = :userNameOrEmail) " +
			"AND u.deleted = false")
	Optional<User> findByUserNameOrEmail(@Param("userNameOrEmail") String userNameOrEmail);

	@Query("SELECT u FROM User u LEFT JOIN FETCH u.roles r LEFT JOIN FETCH r.privileges " +
			"WHERE (u.userName = :userNameOrEmail or u.email = :userNameOrEmail) " +
			"AND u.deleted = false")
	Optional<User> findByUserNameOrEmailAndEagerlyFetchRoles(@Param("userNameOrEmail") String userNameOrEmail);

	@Query("SELECT u FROM User u LEFT JOIN FETCH u.roles " +
			"WHERE u.id = :id AND u.deleted = false")
	Optional<User> findByIdAndEagerlyFetchRoles(@Param("id") Long id);


}
