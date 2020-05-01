package org.nerdizin.eztrial.xml.odm.study.data;

import org.nerdizin.eztrial.xml.odm.base.OdmElement;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;


public class SubjectData implements OdmElement {

    @XmlAttribute(name = "SubjectKey")
    private String subjectKey;

    @XmlElement(name = "StudyEventData")
    private List<StudyEventData> studyEventDatas;


    public String getSubjectKey() {
        return subjectKey;
    }

    public void setSubjectKey(final String subjectKey) {
        this.subjectKey = subjectKey;
    }

    public List<StudyEventData> getStudyEventDatas() {
        return studyEventDatas;
    }

    public void setStudyEventDatas(final List<StudyEventData> studyEventDatas) {
        this.studyEventDatas = studyEventDatas;
    }

    public void addStudyEventData(final StudyEventData studyEventData) {
        if (this.studyEventDatas == null) {
            this.studyEventDatas = new ArrayList<>();
        }
        this.studyEventDatas.add(studyEventData);
    }
}
