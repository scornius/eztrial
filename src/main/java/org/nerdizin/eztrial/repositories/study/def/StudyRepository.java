package org.nerdizin.eztrial.repositories.study.def;

import org.nerdizin.eztrial.entities.study.def.Study;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudyRepository extends CrudRepository<Study,Long> {

	Optional<Study> findByOid(String oid);

}
