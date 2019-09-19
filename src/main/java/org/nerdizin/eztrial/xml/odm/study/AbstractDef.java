package org.nerdizin.eztrial.xml.odm.study;

import org.nerdizin.eztrial.xml.odm.OdmElement;

import javax.xml.bind.annotation.XmlAttribute;

public abstract class AbstractDef extends OdmElement {

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
