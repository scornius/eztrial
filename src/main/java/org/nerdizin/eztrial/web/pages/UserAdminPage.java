package org.nerdizin.eztrial.web.pages;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.nerdizin.eztrial.services.admin.UserService;
import org.nerdizin.eztrial.web.panels.NavigationPanel;
import org.nerdizin.eztrial.web.panels.UserEditPanel;
import org.nerdizin.eztrial.web.panels.UserListPanel;

import javax.inject.Inject;

@WicketHomePage
public class UserAdminPage extends AbstractWebPage {

    @Inject
    private UserService userService;

    public UserAdminPage() {
        add(new NavigationPanel("navigationPanel"));
        add(new UserEditPanel("userEditPanel"));
        add(new UserListPanel("userListPanel", userService));
    }


}
