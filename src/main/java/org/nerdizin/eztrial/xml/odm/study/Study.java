package org.nerdizin.eztrial.xml.odm.study;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;


public class Study {

    @XmlAttribute(name = "OID")
    private String oid;

    @XmlElement(name = "GlobalVariables")
    private GlobalVariables globalVariables;

    @XmlElement(name = "BasicDefinitions")
    private BasicDefinitions basicDefinitions;

    @XmlElement(name = "MetaDataVersion")
    private List<MetaDataVersion> metaDataVersions;


    public String getOid() {
        return oid;
    }

    public void setOid(final String oid) {
        this.oid = oid;
    }

    public GlobalVariables getGlobalVariables() {
        return globalVariables;
    }

    public void setGlobalVariables(final GlobalVariables globalVariables) {
        this.globalVariables = globalVariables;
    }

    public BasicDefinitions getBasicDefinitions() {
        return basicDefinitions;
    }

    public void setBasicDefinitions(final BasicDefinitions basicDefinitions) {
        this.basicDefinitions = basicDefinitions;
    }

    public List<MetaDataVersion> getMetaDataVersions() {
        return metaDataVersions;
    }

    public void setMetaDataVersions(final List<MetaDataVersion> metaDataVersions) {
        this.metaDataVersions = metaDataVersions;
    }
}
