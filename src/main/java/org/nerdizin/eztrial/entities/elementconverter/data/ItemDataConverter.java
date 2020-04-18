package org.nerdizin.eztrial.entities.elementconverter.data;

import org.nerdizin.eztrial.entities.elementconverter.common.OdmElementToEntityConverter;
import org.nerdizin.eztrial.entities.study.data.ItemData;

public class ItemDataConverter
        implements OdmElementToEntityConverter<org.nerdizin.eztrial.xml.odm.study.data.ItemData, ItemData> {

    @Override
    public ItemData convertToEntity(final org.nerdizin.eztrial.xml.odm.study.data.ItemData itemData) {

        final ItemData result = new ItemData();
        result.setOid(itemData.getItemOid());

        return result;
    }

    @Override
    public org.nerdizin.eztrial.xml.odm.study.data.ItemData convertToElement(final ItemData itemData) {

        final org.nerdizin.eztrial.xml.odm.study.data.ItemData result =
                new org.nerdizin.eztrial.xml.odm.study.data.ItemData();
        result.setItemOid(itemData.getOid());

        return result;
    }
}
