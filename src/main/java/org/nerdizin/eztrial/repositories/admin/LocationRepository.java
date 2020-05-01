package org.nerdizin.eztrial.repositories.admin;

import org.nerdizin.eztrial.entities.admin.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface LocationRepository extends PagingAndSortingRepository<Location,Long> {

	Optional<Location> findByOid(String oid);

	Iterable<Location> findAllByOrderByOid();

	@Query("SELECT l FROM Location l JOIN FETCH l.metaDataVersionRefs")
	Iterable<Location> findAllAndFetchChildrenEagerly();

}
