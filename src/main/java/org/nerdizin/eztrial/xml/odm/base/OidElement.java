package org.nerdizin.eztrial.xml.odm.base;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

@XmlSeeAlso({OidNameElement.class})
@XmlTransient
public abstract class OidElement {

	@XmlAttribute(name = "OID")
	private String oid;

	public String getOid() {
		return oid;
	}

	public void setOid(final String oid) {
		this.oid = oid;
	}

}
