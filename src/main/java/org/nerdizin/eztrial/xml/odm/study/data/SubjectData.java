package org.nerdizin.eztrial.xml.odm.study.data;

import javax.xml.bind.annotation.XmlAttribute;

public class SubjectData {

    @XmlAttribute(name = "SubjectKey")
    private String subjectKey;


    public String getSubjectKey() {
        return subjectKey;
    }

    public void setSubjectKey(String subjectKey) {
        this.subjectKey = subjectKey;
    }
}
