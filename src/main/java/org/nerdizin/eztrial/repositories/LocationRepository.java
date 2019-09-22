package org.nerdizin.eztrial.repositories;

import org.nerdizin.eztrial.entities.admin.Location;
import org.nerdizin.eztrial.entities.enums.LocationType;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.stream.Stream;

public interface LocationRepository extends PagingAndSortingRepository<Location,Long> {

	Location findByOid(String oid);

}
