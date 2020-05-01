package org.nerdizin.eztrial.entities.elementconverter.data;

import org.nerdizin.eztrial.entities.elementconverter.common.OdmElementToEntityConverter;
import org.nerdizin.eztrial.entities.study.data.ItemGroupData;

public class ItemGroupDataConverter
        implements OdmElementToEntityConverter<org.nerdizin.eztrial.xml.odm.study.data.ItemGroupData, ItemGroupData> {

    @Override
    public ItemGroupData convertToEntity(final org.nerdizin.eztrial.xml.odm.study.data.ItemGroupData itemGroupData) {

        final ItemGroupData result = new ItemGroupData();
        result.setOid(itemGroupData.getItemGroupOid());

        return result;
    }

    @Override
    public org.nerdizin.eztrial.xml.odm.study.data.ItemGroupData convertToElement(final ItemGroupData itemGroupData) {

        final org.nerdizin.eztrial.xml.odm.study.data.ItemGroupData result =
                new org.nerdizin.eztrial.xml.odm.study.data.ItemGroupData();
        result.setItemGroupOid(itemGroupData.getOid());

        return result;
    }
}
