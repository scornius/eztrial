package org.nerdizin.eztrial.repositories.study.def;

import org.nerdizin.eztrial.entities.study.def.MeasurementUnit;
import org.nerdizin.eztrial.entities.study.def.Study;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MeasurementUnitRepository extends CrudRepository<MeasurementUnit,Long> {

	List<MeasurementUnit> findAllByStudy(Study study);

}
