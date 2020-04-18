package org.nerdizin.eztrial.repositories.study.def;

import org.nerdizin.eztrial.entities.study.def.ItemGroupDef;
import org.nerdizin.eztrial.entities.study.def.MetaDataVersion;
import org.springframework.data.repository.CrudRepository;

public interface ItemGroupDefRepository extends CrudRepository<ItemGroupDef,Long> {

	Iterable<ItemGroupDef> findAllByMetaDataVersion(MetaDataVersion metaDataVersion);
}
