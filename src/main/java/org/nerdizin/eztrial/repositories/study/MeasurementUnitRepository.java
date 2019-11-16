package org.nerdizin.eztrial.repositories.study;

import org.nerdizin.eztrial.entities.study.MeasurementUnit;
import org.nerdizin.eztrial.entities.study.Study;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MeasurementUnitRepository extends CrudRepository<MeasurementUnit,Long> {

	List<MeasurementUnit> findAllByStudy(Study study);

}
