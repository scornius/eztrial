package org.nerdizin.eztrial.repositories.study.def;

import org.nerdizin.eztrial.entities.study.def.MetaDataVersion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface MetaDataVersionRepository extends PagingAndSortingRepository<MetaDataVersion,Long> {

	Optional<MetaDataVersion> findByOid(String oid);

	@Query("SELECT m FROM MetaDataVersion m JOIN FETCH m.eventDefs")
	Iterable<MetaDataVersion> findAllAndFetchChildrenEagerly();

}
