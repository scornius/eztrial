package org.nerdizin.eztrial.repositories.study.data;

import org.nerdizin.eztrial.entities.study.data.FormData;
import org.nerdizin.eztrial.entities.study.data.StudyEventData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FormDataRepository extends CrudRepository<FormData,Long> {

    @Query("select e from FormData e where e.event = :event and e.deleted = false")
    List<FormData> findAllByEvent(@Param("event") final StudyEventData event);

}
