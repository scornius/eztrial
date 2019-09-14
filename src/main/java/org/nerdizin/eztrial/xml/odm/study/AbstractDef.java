package org.nerdizin.eztrial.xml.odm.study;

import javax.xml.bind.annotation.XmlAttribute;

public abstract class AbstractDef {

    @XmlAttribute(name = "OID")
    private String oid;

    @XmlAttribute(name = "Name")
    private String name;


    public String getOid() {
        return oid;
    }

    public void setOid(final String oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
