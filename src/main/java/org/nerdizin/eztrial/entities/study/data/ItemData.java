package org.nerdizin.eztrial.entities.study.data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.OidEntity;
import org.nerdizin.eztrial.entities.enums.DataType;

import javax.persistence.*;

@Entity
@Table(name = "data_items")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="data_type", discriminatorType = DiscriminatorType.STRING)
public abstract class ItemData extends OidEntity {

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

    public abstract DataType getDataType();
}
