package org.nerdizin.eztrial.repositories.study.data;

import org.nerdizin.eztrial.entities.study.data.FormData;
import org.nerdizin.eztrial.entities.study.data.ItemGroupData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemGroupDataRepository extends CrudRepository<ItemGroupData,Long> {

    @Query("select ig from ItemGroupData ig where ig.form = :form and ig.deleted = false")
    List<ItemGroupData> findAllByForm(@Param("form") final FormData form);

}
