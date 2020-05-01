package org.nerdizin.eztrial.entities.study.data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.OidEntity;

import javax.persistence.*;

@Entity
@Table(name = "data_items")
public class ItemData extends OidEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "itemgroup_id")
    private ItemGroupData itemGroup;


    public ItemGroupData getItemGroup() {
        return itemGroup;
    }

    public void setItemGroup(final ItemGroupData itemGroup) {
        this.itemGroup = itemGroup;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
