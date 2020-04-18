package org.nerdizin.eztrial.xml.odm.study.data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class ClinicalData {

    @XmlAttribute(name = "StudyOID")
    private String studyOid;

    @XmlAttribute(name = "MetaDataVersionOID")
    private String metaDataVersionOid;

    @XmlElement(name = "SubjectData")
    private List<SubjectData> subjectDatas;


    public String getStudyOid() {
        return studyOid;
    }

    public void setStudyOid(final String studyOid) {
        this.studyOid = studyOid;
    }

    public String getMetaDataVersionOid() {
        return metaDataVersionOid;
    }

    public void setMetaDataVersionOid(final String metaDataVersionOid) {
        this.metaDataVersionOid = metaDataVersionOid;
    }

    public List<SubjectData> getSubjectDatas() {
        return subjectDatas;
    }

    public void setSubjectDatas(final List<SubjectData> subjectDatas) {
        this.subjectDatas = subjectDatas;
    }

    public void addSubjectData(final SubjectData subjectData) {
        if (this.subjectDatas == null) {
            this.subjectDatas = new ArrayList<>();
        }
        this.subjectDatas.add(subjectData);
    }
}
