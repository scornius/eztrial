package org.nerdizin.eztrial.web.mvc.admin;

import org.nerdizin.eztrial.web.model.admin.Role;

import java.util.List;
import java.util.stream.Collectors;

public class UserUtils {

    private UserUtils() {}

    public static List<Role> getRolesNotAssignedToUser(final List<Role> roles,
                                                       final org.nerdizin.eztrial.web.model.admin.User user) {
        return roles.stream().filter(r -> !user.hasRole(r)).collect(Collectors.toList());
    }
}
