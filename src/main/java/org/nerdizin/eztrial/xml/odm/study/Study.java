package org.nerdizin.eztrial.xml.odm.study;

import org.nerdizin.eztrial.xml.odm.base.OidElement;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;


public class Study extends OidElement {

    @XmlElement(name = "GlobalVariables")
    private GlobalVariables globalVariables;

    @XmlElement(name = "BasicDefinitions")
    private BasicDefinitions basicDefinitions;

    @XmlElement(name = "MetaDataVersion")
    private List<MetaDataVersion> metaDataVersions;


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

    public void addMetaDataVersion(final MetaDataVersion metaDataVersion) {
    	if (this.metaDataVersions == null) {
    		this.metaDataVersions = new ArrayList<>();
		}
    	this.metaDataVersions.add(metaDataVersion);
	}
}
