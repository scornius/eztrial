package org.nerdizin.eztrial.repositories;

import org.nerdizin.eztrial.entities.admin.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	Iterable<User> findAllByOrderByOid();

	User findByUserName(String userName);

}
