package org.nerdizin.eztrial.web.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Location implements UiModel {

	private String oid;
	private String name;
	private String type;
	private boolean active;
	private String label;
	private String affix;
	private Address address;


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

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(final boolean active) {
		this.active = active;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(final String label) {
		this.label = label;
	}

	public String getAffix() {
		return affix;
	}

	public void setAffix(final String affix) {
		this.affix = affix;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(final Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
