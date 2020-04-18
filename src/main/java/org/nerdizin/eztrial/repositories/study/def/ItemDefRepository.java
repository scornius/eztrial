package org.nerdizin.eztrial.repositories.study.def;

import org.nerdizin.eztrial.entities.study.def.ItemDef;
import org.nerdizin.eztrial.entities.study.def.MetaDataVersion;
import org.springframework.data.repository.CrudRepository;

public interface ItemDefRepository extends CrudRepository<ItemDef,Long> {

	Iterable<ItemDef> findAllByMetaDataVersion(MetaDataVersion metaDataVersion);
}
