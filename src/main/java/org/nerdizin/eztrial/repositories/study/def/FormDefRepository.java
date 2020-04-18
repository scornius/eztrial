package org.nerdizin.eztrial.repositories.study.def;

import org.nerdizin.eztrial.entities.study.def.FormDef;
import org.nerdizin.eztrial.entities.study.def.MetaDataVersion;
import org.springframework.data.repository.CrudRepository;

public interface FormDefRepository extends CrudRepository<FormDef,Long> {

	Iterable<FormDef> findAllByMetaDataVersion(MetaDataVersion metaDataVersion);
}
