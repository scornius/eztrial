package org.nerdizin.eztrial.web.validator;

import org.nerdizin.eztrial.web.model.common.Pagination;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PaginationValidator implements Validator {

	@Override
	public boolean supports(final Class<?> aClass) {
		return Pagination.class.equals(aClass);
	}

	@Override
	public void validate(final Object o, final Errors errors) {
		final Pagination pagination = (Pagination) o;
		if (pagination.getSortBy() == null || pagination.getSortBy().length == 0) {
			pagination.setSortBy(new String[]{"oid"});
		}
		if (pagination.getRows() < 1) {
			pagination.setRows(1);
		}
		if (pagination.getPage() < 0) {
			pagination.setPage(0);
		}
	}
}
