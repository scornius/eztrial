package org.nerdizin.eztrial.xml.odm.admin;

import org.nerdizin.eztrial.xml.odm.base.OidElement;

import javax.xml.bind.annotation.XmlValue;

public class Privilege extends OidElement implements Comparable<Privilege> {

	@XmlValue
	private boolean value;

	public boolean getValue() {
		return value;
	}

	public void setValue(final boolean value) {
		this.value = value;
	}

	@Override
	public int compareTo(final Privilege other) {

		if (other == null) {
			return -1;
		}

		return other.getOid().compareTo(getOid());
	}
}
