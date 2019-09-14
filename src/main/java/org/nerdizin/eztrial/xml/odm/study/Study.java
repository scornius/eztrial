package org.nerdizin.eztrial.xml.odm.study;

import org.nerdizin.eztrial.xml.odm.Namespaces;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Study {

    @XmlAttribute(name = "OID")
    private String oid;

    @XmlElement(name = "GlobalVariables", namespace = Namespaces.ODM)
    private GlobalVariables globalVariables;

    @XmlElement(name = "BasicDefinitions", namespace = Namespaces.ODM)
    private BasicDefinitions basicDefinitions;

    @XmlElement(name = "MetaDataVersion", namespace = Namespaces.ODM)
    private List<MetaDataVersion> metaDataVersions;


    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public GlobalVariables getGlobalVariables() {
        return globalVariables;
    }

    public void setGlobalVariables(GlobalVariables globalVariables) {
        this.globalVariables = globalVariables;
    }

    public BasicDefinitions getBasicDefinitions() {
        return basicDefinitions;
    }

    public void setBasicDefinitions(BasicDefinitions basicDefinitions) {
        this.basicDefinitions = basicDefinitions;
    }

    public List<MetaDataVersion> getMetaDataVersions() {
        return metaDataVersions;
    }

    public void setMetaDataVersions(List<MetaDataVersion> metaDataVersions) {
        this.metaDataVersions = metaDataVersions;
    }
}
