package org.nerdizin.eztrial.xml.odm.base;

import javax.xml.bind.annotation.XmlElement;

public abstract class DefElement extends OidNameElement {

	@XmlElement
	private String description;


	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}
}
