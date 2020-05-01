package org.nerdizin.eztrial.repositories.study.data;

import org.nerdizin.eztrial.entities.study.data.ItemData;
import org.nerdizin.eztrial.entities.study.data.ItemGroupData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemDataRepository extends CrudRepository<ItemData,Long> {

    @Query("select i from ItemData i where i.itemGroup = :itemGroup and i.deleted = false")
    List<ItemData> findAllByItemGroup(@Param("itemGroup") ItemGroupData itemGroup);

}
