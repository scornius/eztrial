package org.nerdizin.eztrial.repositories.study.def;

import org.nerdizin.eztrial.entities.study.def.EventDef;
import org.nerdizin.eztrial.entities.study.def.MetaDataVersion;
import org.springframework.data.repository.CrudRepository;

public interface EventDefRepository extends CrudRepository<EventDef,Long> {

	Iterable<EventDef> findAllByMetaDataVersion(MetaDataVersion metaDataVersion);

}
