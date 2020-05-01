package org.nerdizin.eztrial.xml.odm.study.data;

import org.nerdizin.eztrial.entities.enums.DataType;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemDataString extends ItemData {

    @Override
    public DataType getDataType() {
        return DataType.STRING;
    }
}
