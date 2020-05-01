package org.nerdizin.eztrial.entities.elementconverter.data;

import org.nerdizin.eztrial.entities.elementconverter.common.OdmElementToEntityConverter;
import org.nerdizin.eztrial.entities.enums.DataType;
import org.nerdizin.eztrial.entities.study.data.ItemData;
import org.nerdizin.eztrial.entities.study.data.ItemDataInteger;
import org.nerdizin.eztrial.entities.study.data.ItemDataString;

public class ItemDataConverter
        implements OdmElementToEntityConverter<org.nerdizin.eztrial.xml.odm.study.data.ItemData, ItemData> {

    @Override
    public ItemData convertToEntity(final org.nerdizin.eztrial.xml.odm.study.data.ItemData itemData) {

        final ItemData result;
        switch(itemData.getDataType()) {
            case INTEGER:
                result = new ItemDataInteger();
                ((ItemDataInteger) result).setValueInt(Integer.parseInt(itemData.getValue()));
                break;
            case STRING:
                result = new ItemDataString();
                ((ItemDataString) result).setValueString(itemData.getValue());
                break;
            default:
                throw new IllegalArgumentException(String.format("unsupported datatype: %s", itemData.getDataType()));
        }

        result.setOid(itemData.getItemOid());

        return result;
    }

    @Override
    public org.nerdizin.eztrial.xml.odm.study.data.ItemData convertToElement(final ItemData itemData) {

        final org.nerdizin.eztrial.xml.odm.study.data.ItemData result;
        switch(itemData.getDataType()) {
            case INTEGER:
                result = new org.nerdizin.eztrial.xml.odm.study.data.ItemDataInteger();
                result.setValue(((ItemDataInteger) itemData).getValueInt().toString());
                break;
            case STRING:
                result = new org.nerdizin.eztrial.xml.odm.study.data.ItemDataString();
                result.setValue(((ItemDataString) itemData).getValueString());
                break;
            default:
                throw new IllegalArgumentException(String.format("unsupported datatype: %s", itemData.getDataType()));
        }

        result.setItemOid(itemData.getOid());

        return result;
    }
}
