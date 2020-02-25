package org.nerdizin.eztrial.repositories.study;

import org.nerdizin.eztrial.entities.study.ItemGroupDef;
import org.nerdizin.eztrial.entities.study.MetaDataVersion;
import org.springframework.data.repository.CrudRepository;

public interface ItemGroupDefRepository extends CrudRepository<ItemGroupDef,Long> {

	Iterable<ItemGroupDef> findAllByMetaDataVersion(MetaDataVersion metaDataVersion);
}
