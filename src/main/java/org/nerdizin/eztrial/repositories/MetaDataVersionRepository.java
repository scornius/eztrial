package org.nerdizin.eztrial.repositories;

import org.nerdizin.eztrial.entities.study.MetaDataVersion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MetaDataVersionRepository extends PagingAndSortingRepository<MetaDataVersion,Long> {

	MetaDataVersion findByOid(String oid);

	@Query("SELECT m FROM MetaDataVersion m JOIN FETCH m.eventDefs")
	Iterable<MetaDataVersion> findAllAndFetchChildrenEagerly();

}
