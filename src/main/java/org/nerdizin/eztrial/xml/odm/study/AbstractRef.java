package org.nerdizin.eztrial.xml.odm.study;

import org.nerdizin.eztrial.xml.adapter.YesNoBooleanAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public abstract class AbstractRef {

	@XmlAttribute(name = "Mandatory")
	@XmlJavaTypeAdapter(YesNoBooleanAdapter.class)
	private Boolean mandatory;


	public Boolean getMandatory() {
		return mandatory;
	}

	public void setMandatory(final Boolean mandatory) {
		this.mandatory = mandatory;
	}
}
