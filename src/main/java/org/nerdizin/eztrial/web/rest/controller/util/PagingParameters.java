package org.nerdizin.eztrial.web.rest.controller.util;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.domain.Sort;

public class PagingParameters {

	private int page = 1;
	private int size = 1;
	private boolean descending;
	private String[] properties;


	public int getPage() {
		return page;
	}

	public PagingParameters setPage(final int page) {
		this.page = page;
		return this;
	}

	public int getSize() {
		return size;
	}

	public PagingParameters setSize(final int size) {
		this.size = size;
		return this;
	}

	public boolean isDescending() {
		return descending;
	}

	public PagingParameters setDescending(final boolean descending) {
		this.descending = descending;
		return this;
	}

	public String[] getProperties() {
		return properties;
	}

	public PagingParameters setProperties(final String[] properties) {
		this.properties = properties;
		return this;
	}

	public Sort.Direction getSortDirection() {
		return isDescending() ? Sort.Direction.DESC : Sort.Direction.ASC;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
