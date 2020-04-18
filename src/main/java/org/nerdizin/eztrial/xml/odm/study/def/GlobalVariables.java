package org.nerdizin.eztrial.xml.odm.study.def;

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

    public void setStudyName(final String studyName) {
        this.studyName = studyName;
    }

    public String getStudyDescription() {
        return studyDescription;
    }

    public void setStudyDescription(final String studyDescription) {
        this.studyDescription = studyDescription;
    }

    public String getProtocolName() {
        return protocolName;
    }

    public void setProtocolName(final String protocolName) {
        this.protocolName = protocolName;
    }
}
