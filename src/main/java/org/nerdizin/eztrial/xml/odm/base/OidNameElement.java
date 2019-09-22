package org.nerdizin.eztrial.xml.odm.base;

import org.nerdizin.eztrial.xml.odm.admin.Location;
import org.nerdizin.eztrial.xml.odm.study.MeasurementUnit;
import org.nerdizin.eztrial.xml.odm.study.MetaDataVersion;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({DefElement.class, MeasurementUnit.class, MetaDataVersion.class, Location.class})
public abstract class OidNameElement extends OidElement implements OdmElement {

	@XmlAttribute(name = "Name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}
}
