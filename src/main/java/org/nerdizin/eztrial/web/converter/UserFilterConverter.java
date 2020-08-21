package org.nerdizin.eztrial.web.converter;

import org.nerdizin.eztrial.web.model.admin.UserFilter;
import org.springframework.stereotype.Component;

@Component
public class UserFilterConverter {

    public org.nerdizin.eztrial.repositories.admin.UserFilter convert(final UserFilter userFilter) {

        final org.nerdizin.eztrial.repositories.admin.UserFilter result =
                new org.nerdizin.eztrial.repositories.admin.UserFilter();
        result.setUserName(userFilter.getUserName());
        result.setActive(userFilter.isActive());

        return result;
    }

}
