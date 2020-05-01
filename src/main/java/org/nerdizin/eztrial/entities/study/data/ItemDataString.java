package org.nerdizin.eztrial.entities.study.data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(DataType.STRING)
public class ItemDataString extends ItemData {

    @Column(name = "value_string")
    private String valueString;


    public String getValueString() {
        return valueString;
    }

    public void setValueString(final String valueString) {
        this.valueString = valueString;
    }

    @Override
    public org.nerdizin.eztrial.entities.enums.DataType getDataType() {
        return org.nerdizin.eztrial.entities.enums.DataType.STRING;
    }
}
