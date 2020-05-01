package org.nerdizin.eztrial.web.converter;


import org.nerdizin.eztrial.entities.admin.Role;

public class RoleConverter implements Entity2UiModelConverter<Role, org.nerdizin.eztrial.web.model.admin.Role> {

    @Override
    public org.nerdizin.eztrial.web.model.admin.Role convertToUiModel(Role role) {
        return new org.nerdizin.eztrial.web.model.admin.Role()
                .setOid(role.getOid())
                .setName(role.getName());
    }

    @Override
    public Role convertToEntity(final org.nerdizin.eztrial.web.model.admin.Role role) {
        return null;
    }
}
