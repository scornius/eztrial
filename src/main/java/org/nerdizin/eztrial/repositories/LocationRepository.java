package org.nerdizin.eztrial.repositories;

import org.nerdizin.eztrial.entities.admin.Location;
import org.nerdizin.eztrial.entities.enums.LocationType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.stream.Stream;

public interface LocationRepository extends PagingAndSortingRepository<Location,Long> {

	Location findByOid(String oid);

	@Query("SELECT l FROM Location l JOIN FETCH l.metaDataVersionRefs")
	Iterable<Location> findAllAndFetchChildrenEagerly();

}
