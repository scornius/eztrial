package org.nerdizin.eztrial.xml.odm.study;

import org.nerdizin.eztrial.xml.Namespaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;


public class MetaDataVersion {

    @XmlAttribute(name = "OID")
    private String oid;

    @XmlAttribute(name = "Name")
    private String name;

    @XmlElement(name = "StudyEventDef")
    private List<StudyEventDef> studyElementDefs;


    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudyEventDef> getStudyElementDefs() {
        return studyElementDefs;
    }

    public void setStudyElementDefs(List<StudyEventDef> studyElementDefs) {
        this.studyElementDefs = studyElementDefs;
    }
}
