package org.nerdizin.eztrial.web.converter;

import org.nerdizin.eztrial.entities.admin.Role;
import org.nerdizin.eztrial.entities.admin.User;
import org.springframework.stereotype.Component;

@Component
public class UserWithRolesConverter extends UserConverter {

    @Override
    public org.nerdizin.eztrial.web.model.admin.User convertToUiModel(final User entity) {
        final org.nerdizin.eztrial.web.model.admin.User result = super.convertToUiModel(entity);

        if (entity.hasRoles()) {
            final RoleConverter roleConverter = new RoleConverter();
            for (final Role role : entity.getRoles()) {
                result.addRole(roleConverter.convertToUiModel(role));
            }
        }

        return result;
    }

}
