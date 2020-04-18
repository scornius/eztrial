package org.nerdizin.eztrial.entities.elementconverter.data;

import org.nerdizin.eztrial.entities.elementconverter.common.OdmElementToEntityConverter;
import org.nerdizin.eztrial.entities.study.data.SubjectData;

public class SubjectConverter implements
        OdmElementToEntityConverter<org.nerdizin.eztrial.xml.odm.study.data.SubjectData, SubjectData> {

    @Override
    public SubjectData convertToEntity(org.nerdizin.eztrial.xml.odm.study.data.SubjectData subjectData) {

        final SubjectData result = new SubjectData();
        result.setSubjectKey(subjectData.getSubjectKey());

        return result;
    }

    @Override
    public org.nerdizin.eztrial.xml.odm.study.data.SubjectData convertToElement(SubjectData subjectData) {

        final org.nerdizin.eztrial.xml.odm.study.data.SubjectData result =
                new org.nerdizin.eztrial.xml.odm.study.data.SubjectData();
        result.setSubjectKey(subjectData.getSubjectKey());

        return result;
    }
}
