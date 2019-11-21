package org.nerdizin.eztrial.web.model.common;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.domain.Sort;

public class Pagination {

	private int page = 0;
	private int rows = 1;
	private boolean descending;
	private String[] properties;


	public int getPage() {
		return page;
	}

	public Pagination setPage(final int page) {
		this.page = page;
		return this;
	}

	public int getRows() {
		return rows;
	}

	public Pagination setRows(final int rows) {
		this.rows = rows;
		return this;
	}

	public boolean isDescending() {
		return descending;
	}

	public Pagination setDescending(final boolean descending) {
		this.descending = descending;
		return this;
	}

	public String[] getProperties() {
		return properties;
	}

	public Pagination setProperties(final String[] properties) {
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
