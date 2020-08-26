package org.nerdizin.eztrial.web.panels;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.nerdizin.eztrial.web.pages.HomePage;
import org.nerdizin.eztrial.web.pages.UserAdminPage;

public class NavigationPanel extends Panel {

    public NavigationPanel(final String id) {
        super(id);
        init();
    }

    private void init() {
        add(new Link<Void>("home") {
            @Override
            public void onClick() {
                setResponsePage(HomePage.class);
            }
        });
        add(new Link<Void>("userAdministration") {
            @Override
            public void onClick() {
                setResponsePage(UserAdminPage.class);
            }
        });
    }
}
