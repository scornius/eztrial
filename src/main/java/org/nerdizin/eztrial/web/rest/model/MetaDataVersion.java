package org.nerdizin.eztrial.web.rest.model;

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
}
