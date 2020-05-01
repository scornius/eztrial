package org.nerdizin.eztrial.entities.elementconverter.data;

import org.nerdizin.eztrial.entities.elementconverter.common.OdmElementToEntityConverter;
import org.nerdizin.eztrial.entities.study.data.FormData;

public class FormDataConverter
        implements OdmElementToEntityConverter<org.nerdizin.eztrial.xml.odm.study.data.FormData, FormData> {

    @Override
    public FormData convertToEntity(org.nerdizin.eztrial.xml.odm.study.data.FormData formData) {

        final FormData result = new FormData();
        result.setOid(formData.getFormOid());

        return result;
    }

    @Override
    public org.nerdizin.eztrial.xml.odm.study.data.FormData convertToElement(FormData formData) {

        final org.nerdizin.eztrial.xml.odm.study.data.FormData result =
                new org.nerdizin.eztrial.xml.odm.study.data.FormData();
        result.setFormOid(formData.getOid());

        return result;
    }
}
