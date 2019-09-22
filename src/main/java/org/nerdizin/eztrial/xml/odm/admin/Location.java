package org.nerdizin.eztrial.xml.odm.admin;

import org.nerdizin.eztrial.xml.adapter.LocationTypeAdapter;
import org.nerdizin.eztrial.xml.odm.base.OdmElement;
import org.nerdizin.eztrial.xml.odm.base.OidNameElement;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;


public class Location extends OidNameElement {

    @XmlAttribute(name = "LocationType")
    @XmlJavaTypeAdapter(LocationTypeAdapter.class)
    private LocationType locationType;

    @XmlElement(name = "MetaDataVersionRef")
	private List<MetaDataVersionRef> metaDataVersionRefs;


    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(final LocationType locationType) {
        this.locationType = locationType;
    }

	public List<MetaDataVersionRef> getMetaDataVersionRefs() {
		return metaDataVersionRefs;
	}

	public void setMetaDataVersionRefs(final List<MetaDataVersionRef> metaDataVersionRefs) {
		this.metaDataVersionRefs = metaDataVersionRefs;
	}

	public void addMetaDataVersionRef(final MetaDataVersionRef metaDataVersionRef) {
    	if (this.metaDataVersionRefs == null) {
    		this.metaDataVersionRefs = new ArrayList<>();
		}
    	this.metaDataVersionRefs.add(metaDataVersionRef);
	}
}
