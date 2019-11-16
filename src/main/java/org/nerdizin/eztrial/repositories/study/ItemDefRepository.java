package org.nerdizin.eztrial.repositories.study;

import org.nerdizin.eztrial.entities.study.ItemDef;
import org.nerdizin.eztrial.entities.study.MetaDataVersion;
import org.springframework.data.repository.CrudRepository;

public interface ItemDefRepository extends CrudRepository<ItemDef,Long> {

	Iterable<ItemDef> findAllByMetaDataVersion(MetaDataVersion metaDataVersion);
}
