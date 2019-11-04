package org.nerdizin.eztrial.repositories;

import org.nerdizin.eztrial.entities.admin.SignatureDef;
import org.springframework.data.repository.CrudRepository;

public interface SignatureDefRepository extends CrudRepository<SignatureDef,Long> {

	Iterable<SignatureDef> findAllByOrderByOid();

}
