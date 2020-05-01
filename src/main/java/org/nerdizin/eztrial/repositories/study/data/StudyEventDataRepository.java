package org.nerdizin.eztrial.repositories.study.data;

import org.nerdizin.eztrial.entities.study.data.StudyEventData;
import org.nerdizin.eztrial.entities.study.data.SubjectData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudyEventDataRepository extends CrudRepository<StudyEventData,Long> {

    @Query("select e from StudyEventData e where e.subject = :subject and e.deleted = false")
    List<StudyEventData> findAllBySubject(@Param("subject") final SubjectData subject);

}
