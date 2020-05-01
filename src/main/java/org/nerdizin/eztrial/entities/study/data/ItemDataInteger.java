package org.nerdizin.eztrial.entities.study.data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(DataType.INTEGER)
public class ItemDataInteger extends ItemData {

    @Column
    private Integer valueInt;


    public Integer getValueInt() {
        return valueInt;
    }

    public void setValueInt(final Integer valueInt) {
        this.valueInt = valueInt;
    }

    @Override
    public org.nerdizin.eztrial.entities.enums.DataType getDataType() {
        return org.nerdizin.eztrial.entities.enums.DataType.INTEGER;
    }
}
