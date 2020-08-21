package org.nerdizin.eztrial.web.pages;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.WebPage;
import org.nerdizin.eztrial.services.admin.UserService;
import org.nerdizin.eztrial.web.panels.UserListPanel;

import javax.inject.Inject;

@WicketHomePage
public class HomePage extends WebPage {

    @Inject
    private UserService userService;

    public HomePage() {
        add(new UserListPanel("userListPanel", userService));
    }


}
