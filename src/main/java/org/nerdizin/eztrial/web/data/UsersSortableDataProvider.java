package org.nerdizin.eztrial.web.data;

import org.apache.wicket.extensions.markup.html.repeater.data.table.filter.IFilterStateLocator;
import org.apache.wicket.model.IModel;
import org.nerdizin.eztrial.repositories.admin.UserRepository;
import org.nerdizin.eztrial.web.converter.UserConverter;
import org.nerdizin.eztrial.web.converter.UserFilterConverter;
import org.nerdizin.eztrial.web.model.admin.User;
import org.nerdizin.eztrial.web.model.admin.UserFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Iterator;

public class UsersSortableDataProvider extends AbstractSortableDataProvider<User>
    implements IFilterStateLocator<UserFilter> {

    private transient final UserRepository userRepository;
    private transient final UserConverter userConverter;
    private transient final UserFilterConverter userFilterConverter;
    private UserFilter userFilter = new UserFilter();

    public UsersSortableDataProvider(final int pageSize,
                                     final UserRepository userRepository,
                                     final UserConverter userConverter,
                                     final UserFilterConverter userFilterConverter) {
        super(pageSize);
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.userFilterConverter = userFilterConverter;
    }

    @Override
    public Iterator<? extends User> iterator(final long first, final long count) {

        final Page<org.nerdizin.eztrial.entities.admin.User> page = userRepository.findAll(
                PageRequest.of(getPageNumber(first), getPageSize(), getSortDirection(), getSortProperty()),
                userFilterConverter.convert(userFilter)
        );

        final Page<User> result = page.map(userConverter::convertToUiModel);
        return result.iterator();
    }

    @Override
    public long size() {
        return userRepository.countAll(userFilterConverter.convert(userFilter));
    }

    @Override
    public IModel<User> model(final User user) {
        return (IModel<User>) () -> user;
    }

    @Override
    public UserFilter getFilterState() {
        return userFilter;
    }

    @Override
    public void setFilterState(final UserFilter userFilter) {
        this.userFilter = userFilter;
    }
}
