package org.nerdizin.eztrial.repositories.study;

import org.nerdizin.eztrial.entities.study.Study;
import org.springframework.data.repository.CrudRepository;

public interface StudyRepository extends CrudRepository<Study,Long> {

	Study findByOid(String oid);

}
