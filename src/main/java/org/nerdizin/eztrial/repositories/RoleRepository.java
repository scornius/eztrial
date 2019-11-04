package org.nerdizin.eztrial.repositories;


import org.nerdizin.eztrial.entities.admin.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

	Iterable<Role> findAllByOrderByOid();

}
