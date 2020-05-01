package org.nerdizin.eztrial.repositories.study.data;

import org.nerdizin.eztrial.entities.study.data.SubjectData;
import org.nerdizin.eztrial.entities.study.def.MetaDataVersion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectDataRepository extends CrudRepository<SubjectData,Long> {

    @Query("select s from SubjectData s where s.mdv = :mdv order by s.subjectKey")
    List<SubjectData> findAllByMdv(@Param("mdv") final MetaDataVersion mdv);

}
