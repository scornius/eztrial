package org.nerdizin.eztrial.xml.odm.study;

import org.nerdizin.eztrial.xml.odm.Namespaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class GlobalVariables {

    @XmlElement(name = "StudyName", namespace = Namespaces.ODM)
    private String studyName;

    @XmlElement(name = "StudyDescription", namespace = Namespaces.ODM)
    private String studyDescription;

    @XmlElement(name = "ProtocolName", namespace = Namespaces.ODM)
    private String protocolName;


    public String getStudyName() {
        return studyName;
    }

    public void setStudyName(String studyName) {
        this.studyName = studyName;
    }

    public String getStudyDescription() {
        return studyDescription;
    }

    public void setStudyDescription(String studyDescription) {
        this.studyDescription = studyDescription;
    }

    public String getProtocolName() {
        return protocolName;
    }

    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }
}
