package org.nerdizin.eztrial.repositories.admin;


import org.nerdizin.eztrial.entities.admin.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

	Iterable<Role> findAllByOrderByOid();

	Optional<Role> findByOid(String oid);
}
