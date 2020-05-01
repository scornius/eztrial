package org.nerdizin.eztrial.entities.study.data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(DataType.FLOAT)
public class ItemDataFloat extends ItemData {

    @Column(name = "value_float", precision = 15, scale = 5)
    private BigDecimal valueFloat;


    public BigDecimal getValueFloat() {
        return valueFloat;
    }

    public void setValueFloat(final BigDecimal valueFloat) {
        this.valueFloat = valueFloat;
    }

    @Override
    public org.nerdizin.eztrial.entities.enums.DataType getDataType() {
        return org.nerdizin.eztrial.entities.enums.DataType.FLOAT;
    }
}
