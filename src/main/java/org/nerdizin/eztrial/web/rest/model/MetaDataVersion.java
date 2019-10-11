package org.nerdizin.eztrial.web.rest.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MetaDataVersion implements UiModel {

	private String oid;
	private String name;


	public String getOid() {
		return oid;
	}

	public MetaDataVersion setOid(final String oid) {
		this.oid = oid;
		return this;
	}

	public String getName() {
		return name;
	}

	public MetaDataVersion setName(final String name) {
		this.name = name;
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
