package org.nerdizin.eztrial.xml.odm.study.data;

import org.nerdizin.eztrial.entities.enums.DataType;

public class ItemDataInteger extends ItemData {

    @Override
    public DataType getDataType() {
        return DataType.INTEGER;
    }
}
