package org.nerdizin.eztrial.repositories;

import org.nerdizin.eztrial.entities.admin.Privilege;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PrivilegeRepository extends PagingAndSortingRepository<Privilege, Long> {

}
