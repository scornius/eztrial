package org.nerdizin.eztrial.xml.odm.study;

import javax.xml.bind.annotation.*;

public class StudyEventDef {

    @XmlAttribute(name = "OID")
    private String oid;

    @XmlElement(name = "FormDef")
    private FormDef formDef;


}
