package org.nerdizin.eztrial.xml.odm.study;

import org.nerdizin.eztrial.xml.Namespaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


public class GlobalVariables {

    @XmlElement(name = "StudyName")
    private String studyName;

    @XmlElement(name = "StudyDescription")
    private String studyDescription;

    @XmlElement(name = "ProtocolName")
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
