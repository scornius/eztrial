package org.nerdizin.eztrial.web.model.common;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.domain.Sort;

import java.util.HashMap;
import java.util.Map;

public class Pagination {

	private static final int DEFAULT_PAGE_SIZE = 2;

	private int page = 0;
	private int rows = DEFAULT_PAGE_SIZE;
	private boolean descending;
	private String[] sortBy = new String[0];
	private Map<String,String> filters = new HashMap<>();

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

	public String[] getSortBy() {
		return sortBy;
	}

	public Pagination setSortBy(final String[] sortBy) {
		this.sortBy = sortBy;
		return this;
	}

	public Map<String,String> getFilters() {
		return filters;
	}

	public void setFilters(final Map<String,String> filters) {
		this.filters = filters;
	}

	public Sort.Direction getSortDirection() {
		return isDescending() ? Sort.Direction.DESC : Sort.Direction.ASC;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
