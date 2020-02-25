package org.nerdizin.eztrial.web.model.common;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PropertyFilter {

	private String name;
	private String value;

	public PropertyFilter(final String name, final String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
