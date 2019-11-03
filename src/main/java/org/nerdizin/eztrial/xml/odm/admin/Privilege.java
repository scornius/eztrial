package org.nerdizin.eztrial.xml.odm.admin;

import org.nerdizin.eztrial.xml.odm.base.OidElement;

public class Privilege extends OidElement implements Comparable<Privilege> {

	private boolean value;

	public boolean isValue() {
		return value;
	}

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
