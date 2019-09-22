package org.nerdizin.eztrial.repositories;

import org.nerdizin.eztrial.entities.study.EventDef;
import org.nerdizin.eztrial.entities.study.MetaDataVersion;
import org.springframework.data.repository.CrudRepository;

public interface EventDefRepository extends CrudRepository<EventDef,Long> {

	Iterable<EventDef> findAllByMetaDataVersion(MetaDataVersion metaDataVersion);

}
