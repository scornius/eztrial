package org.nerdizin.eztrial.web.data;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.springframework.data.domain.Sort;

public abstract class AbstractSortableDataProvider<T> extends SortableDataProvider<T, String> {

    private static final String DEFAULT_SORT_PROPERTY = "id";
    private final int pageSize;

    protected AbstractSortableDataProvider(final int pageSize) {
        this.pageSize = pageSize;
    }

    protected int getPageNumber(final long first) {
        return (int) first / pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    protected Sort.Direction getSortDirection() {
        final SortParam<String> sort = getSort();
        if (sort != null) {
            return sort.isAscending() ? Sort.Direction.ASC : Sort.Direction.DESC;
        } else {
            return Sort.Direction.DESC;
        }
    }

    protected String getSortProperty() {
        final SortParam<String> sort = getSort();
        if (sort != null) {
            return sort.getProperty();
        } else {
            return DEFAULT_SORT_PROPERTY;
        }
    }
}
