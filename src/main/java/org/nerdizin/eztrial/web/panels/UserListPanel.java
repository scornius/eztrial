package org.nerdizin.eztrial.web.panels;

import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByBorder;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.nerdizin.eztrial.services.admin.UserService;
import org.nerdizin.eztrial.web.data.UsersSortableDataProvider;
import org.nerdizin.eztrial.web.model.admin.User;


public class UserListPanel extends Panel {

    private final UserService userService;
    private final UsersSortableDataProvider usersSortableDataProvider;

    public UserListPanel(final String id, final UserService userService) {
        super(id);
        this.userService = userService;
        this.usersSortableDataProvider = userService.getSortableDataProvider();
        init();
    }

    private void init() {
        final DataView<User> usersDataView = getUsersDataView();
        addHeaders();
        add(usersDataView);
        add(new AjaxPagingNavigator("pagingNavigator", usersDataView));
    }

    private DataView<User> getUsersDataView() {
        final DataView<User> dataView = new DataView<>("userList", usersSortableDataProvider) {
            public void populateItem(final Item item) {
                final User user = (User) item.getModelObject();
                item.add(new Label("oid", user.getOid()));
                item.add(new Label("userName", user.getUserName()));
                item.add(new Label("active", user.isActive()));
                item.add(new Label("firstName", user.getFirstName()));
                item.add(new Label("lastName", user.getLastName()));
                item.add(new Label("email", user.getEmail()));
            }
        };
        dataView.setOutputMarkupId(true);

        return dataView;
    }

    private void addHeaders() {
        add(new OrderByBorder<>("sort.oid", "oid", usersSortableDataProvider));
        add(new OrderByBorder<>("sort.userName", "userName", usersSortableDataProvider));
        add(new OrderByBorder<>("sort.active", "active", usersSortableDataProvider));
        add(new OrderByBorder<>("sort.firstName", "firstName", usersSortableDataProvider));
        add(new OrderByBorder<>("sort.lastName", "lastName", usersSortableDataProvider));
        add(new OrderByBorder<>("sort.email", "email", usersSortableDataProvider));
    }
}
