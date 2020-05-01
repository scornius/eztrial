package org.nerdizin.eztrial.xml.odm.base;

import org.nerdizin.eztrial.xml.odm.study.def.Description;

import javax.xml.bind.annotation.XmlElement;

public abstract class DefElement extends OidNameElement {

	@XmlElement(name = "Description")
	private Description description;


	public Description getDescription() {
		return description;
	}

	public void setDescription(final Description description) {
		this.description = description;
	}
}
