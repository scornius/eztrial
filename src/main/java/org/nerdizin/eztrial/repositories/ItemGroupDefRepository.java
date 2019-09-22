package org.nerdizin.eztrial.repositories;

import org.nerdizin.eztrial.entities.study.FormDef;
import org.nerdizin.eztrial.entities.study.ItemGroupDef;
import org.nerdizin.eztrial.entities.study.MetaDataVersion;
import org.springframework.data.repository.CrudRepository;

public interface ItemGroupDefRepository extends CrudRepository<ItemGroupDef,Long> {

	Iterable<ItemGroupDef> findAllByMetaDataVersion(MetaDataVersion metaDataVersion);
}
