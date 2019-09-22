package org.nerdizin.eztrial.xml.odm.base;

import org.nerdizin.eztrial.xml.adapter.YesNoBooleanAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public abstract class RepeatingDefElement extends DefElement {

	@XmlAttribute(name = "Repeating")
	@XmlJavaTypeAdapter(YesNoBooleanAdapter.class)
	private Boolean repeating;


	public boolean getRepeating() {
		return repeating;
	}

	public void setRepeating(final boolean repeating) {
		this.repeating = repeating;
	}
}
