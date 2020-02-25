package org.nerdizin.eztrial.repositories.study;

import org.nerdizin.eztrial.entities.study.FormDef;
import org.nerdizin.eztrial.entities.study.MetaDataVersion;
import org.springframework.data.repository.CrudRepository;

public interface FormDefRepository extends CrudRepository<FormDef,Long> {

	Iterable<FormDef> findAllByMetaDataVersion(MetaDataVersion metaDataVersion);
}
