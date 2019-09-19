package org.nerdizin.eztrial.xml.odm.admin;

import org.nerdizin.eztrial.xml.adapter.LocationTypeAdapter;
import org.nerdizin.eztrial.xml.odm.OdmElement;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


public class Location extends OdmElement {

    @XmlAttribute(name = "OID")
    private String oid;

    @XmlAttribute(name = "Name")
    private String name;

    @XmlAttribute(name = "LocationType")
    @XmlJavaTypeAdapter(LocationTypeAdapter.class)
    private LocationType locationType;

    @XmlElement(name = "MetaDataVersionRef")
	private MetaDataVersionRef metaDataVersionRef;


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

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(final LocationType locationType) {
        this.locationType = locationType;
    }

	public MetaDataVersionRef getMetaDataVersionRef() {
		return metaDataVersionRef;
	}

	public void setMetaDataVersionRef(final MetaDataVersionRef metaDataVersionRef) {
		this.metaDataVersionRef = metaDataVersionRef;
	}
}
