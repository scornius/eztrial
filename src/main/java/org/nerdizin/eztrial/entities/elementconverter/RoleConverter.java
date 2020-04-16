package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.admin.Role;
import org.nerdizin.eztrial.xml.odm.admin.Privilege;

public class RoleConverter implements OdmElementToEntityConverter<org.nerdizin.eztrial.xml.odm.admin.Role,Role> {

	@Override
	public Role convertToEntity(final org.nerdizin.eztrial.xml.odm.admin.Role role) {

		final Role result = new Role();
		result.setOid(role.getOid());
		result.setName(role.getName());
		result.setDescription(role.getDescription());

		if (role.getPrivileges() != null) {
			final PrivilegeConverter privilegeConverter = new PrivilegeConverter();
			for (final Privilege privilege : role.getPrivileges()) {
				result.addPrivilege(privilegeConverter.convertToEntity(privilege));
			}
		}

		return result;
	}

	@Override
	public org.nerdizin.eztrial.xml.odm.admin.Role convertToElement(final Role role) {

		final org.nerdizin.eztrial.xml.odm.admin.Role result = new org.nerdizin.eztrial.xml.odm.admin.Role();
		result.setOid(role.getOid());
		result.setName(role.getName());
		result.setDescription(role.getDescription());

		if (role.getPrivileges() != null) {
			final PrivilegeConverter privilegeConverter = new PrivilegeConverter();
			for (org.nerdizin.eztrial.entities.admin.Privilege privilege : role.getPrivileges()) {
				result.addPrivilege(privilegeConverter.convertToElement(privilege));
			}
		}

		return result;
	}
}
