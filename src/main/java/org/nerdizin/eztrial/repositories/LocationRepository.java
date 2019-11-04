package org.nerdizin.eztrial.repositories;

import org.nerdizin.eztrial.entities.admin.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LocationRepository extends PagingAndSortingRepository<Location,Long> {

	Location findByOid(String oid);

	Iterable<Location> findAllByOrderByOid();

	@Query("SELECT l FROM Location l JOIN FETCH l.metaDataVersionRefs")
	Iterable<Location> findAllAndFetchChildrenEagerly();

}
