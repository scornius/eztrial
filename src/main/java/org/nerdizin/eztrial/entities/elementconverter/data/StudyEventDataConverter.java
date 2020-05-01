package org.nerdizin.eztrial.entities.elementconverter.data;

import org.nerdizin.eztrial.entities.elementconverter.common.OdmElementToEntityConverter;
import org.nerdizin.eztrial.entities.study.data.StudyEventData;

public class StudyEventDataConverter implements
        OdmElementToEntityConverter<org.nerdizin.eztrial.xml.odm.study.data.StudyEventData, StudyEventData> {

    @Override
    public StudyEventData convertToEntity(final org.nerdizin.eztrial.xml.odm.study.data.StudyEventData studyEventData) {

        final StudyEventData result = new StudyEventData();
        result.setOid(studyEventData.getStudyEventOid());

        return result;
    }

    @Override
    public org.nerdizin.eztrial.xml.odm.study.data.StudyEventData convertToElement(final StudyEventData studyEventData) {

        final org.nerdizin.eztrial.xml.odm.study.data.StudyEventData result =
                new org.nerdizin.eztrial.xml.odm.study.data.StudyEventData();
        result.setStudyEventOid(studyEventData.getOid());

        return result;
    }
}
