package org.nerdizin.eztrial.entities.elementconverter.data;

import org.nerdizin.eztrial.entities.elementconverter.common.OdmElementToEntityConverter;
import org.nerdizin.eztrial.entities.study.data.ItemData;
import org.nerdizin.eztrial.entities.study.data.ItemDataFloat;
import org.nerdizin.eztrial.entities.study.data.ItemDataInteger;
import org.nerdizin.eztrial.entities.study.data.ItemDataString;

import java.math.BigDecimal;

public class ItemDataConverter
        implements OdmElementToEntityConverter<org.nerdizin.eztrial.xml.odm.study.data.ItemData, ItemData> {

    @Override
    public ItemData convertToEntity(final org.nerdizin.eztrial.xml.odm.study.data.ItemData itemData) {

        final ItemData result = getItemData(itemData);
        result.setValueOriginal(itemData.getValue());
        result.setOid(itemData.getItemOid());

        return result;
    }

    private ItemData getItemData(final org.nerdizin.eztrial.xml.odm.study.data.ItemData itemData) {
        switch(itemData.getDataType()) {
            case INTEGER:
                return getItemDataIntegerEntity(itemData);
            case STRING:
                return getItemDataStringEntity(itemData);
            case FLOAT:
                return getItemDataFloatEntity(itemData);
            default:
                throw new IllegalArgumentException(String.format("unsupported datatype: %s", itemData.getDataType()));
        }
    }

    private ItemData getItemDataFloatEntity(final org.nerdizin.eztrial.xml.odm.study.data.ItemData itemData) {
        final ItemDataFloat result = new ItemDataFloat();
        final String rawFloat = itemData.getValue();
        result.setValueFloat(new BigDecimal(rawFloat));
        return result;
    }

    private ItemData getItemDataStringEntity(final org.nerdizin.eztrial.xml.odm.study.data.ItemData itemData) {
        final ItemDataString result = new ItemDataString();
        result.setValueString(itemData.getValue());
        return result;
    }

    private ItemData getItemDataIntegerEntity(final org.nerdizin.eztrial.xml.odm.study.data.ItemData itemData) {
        final ItemDataInteger result = new ItemDataInteger();
        result.setValueInt(Integer.parseInt(itemData.getValue()));
        return result;
    }

    @Override
    public org.nerdizin.eztrial.xml.odm.study.data.ItemData convertToElement(final ItemData itemData) {

        final org.nerdizin.eztrial.xml.odm.study.data.ItemData result = getItemData(itemData);
        result.setItemOid(itemData.getOid());

        return result;
    }

    private org.nerdizin.eztrial.xml.odm.study.data.ItemData getItemData(final ItemData itemData) {
        switch(itemData.getDataType()) {
            case INTEGER:
                return getItemDataInteger((ItemDataInteger) itemData);
            case STRING:
                return getItemDataString((ItemDataString) itemData);
            case FLOAT:
                return getItemDataFloat((ItemDataFloat) itemData);
            default:
                throw new IllegalArgumentException(String.format("unsupported datatype: %s", itemData.getDataType()));
        }
    }

    private org.nerdizin.eztrial.xml.odm.study.data.ItemData getItemDataFloat(final ItemDataFloat itemData) {
        final org.nerdizin.eztrial.xml.odm.study.data.ItemData result =
                new org.nerdizin.eztrial.xml.odm.study.data.ItemDataFloat();
        final BigDecimal valueFloat = itemData.getValueFloat();
        result.setValue(valueFloat.toPlainString());
        return result;
    }

    private org.nerdizin.eztrial.xml.odm.study.data.ItemData getItemDataString(final ItemDataString itemData) {
        final org.nerdizin.eztrial.xml.odm.study.data.ItemData result =
                new org.nerdizin.eztrial.xml.odm.study.data.ItemDataString();
        result.setValue(itemData.getValueString());
        return result;
    }

    private org.nerdizin.eztrial.xml.odm.study.data.ItemData getItemDataInteger(final ItemDataInteger itemData) {
        final org.nerdizin.eztrial.xml.odm.study.data.ItemData result =
                new org.nerdizin.eztrial.xml.odm.study.data.ItemDataInteger();
        result.setValue(itemData.getValueInt().toString());
        return result;
    }
}
