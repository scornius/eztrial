package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.admin.Role;
import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.xml.odm.admin.RoleRef;
import org.nerdizin.eztrial.xml.odm.admin.UserType;

public class UserConverter implements OdmElementToEntityConverter<org.nerdizin.eztrial.xml.odm.admin.User,User> {

	@Override
	public User convertToEntity(final org.nerdizin.eztrial.xml.odm.admin.User user) {

		final User result = new User();
		result.setUserName(user.getLoginName());
		result.setOid(user.getOid());
		result.setPassword(user.getPassword());
		result.setFirstName(user.getFirstName());
		result.setLastName(user.getLastName());
		result.setPhone(user.getPhone());
		result.setEmail(user.getEmail());
		result.setActive(user.isActive());

		if (user.getUserType() != null) {
			result.setType(org.nerdizin.eztrial.entities.enums.UserType.fromCode(user.getUserType().getCode()));
		}

		if (user.getAddress() != null) {
			final AddressConverter addressConverter = new AddressConverter();
			result.setAddress(addressConverter.convertToEntity(user.getAddress()));
		}

		return result;
	}

	@Override
	public org.nerdizin.eztrial.xml.odm.admin.User convertToElement(final User user) {

		final org.nerdizin.eztrial.xml.odm.admin.User result = new org.nerdizin.eztrial.xml.odm.admin.User();
		result.setOid(user.getOid());
		result.setLoginName(user.getUserName());
		result.setPassword(user.getPassword());
		result.setFirstName(user.getFirstName());
		result.setLastName(user.getLastName());
		result.setPhone(user.getPhone());
		result.setEmail(user.getEmail());
		result.setActive(user.isActive());

		if (user.getType() != null) {
			result.setUserType(UserType.fromCode(user.getType().getCode()));
		}

		if (user.getAddress() != null) {
			final AddressConverter addressConverter = new AddressConverter();
			result.setAddress(addressConverter.convertToElement(user.getAddress()));
		}

		if (user.getRoles() != null) {
			for (final Role role : user.getRoles()) {
				final RoleRef roleRef = new RoleRef();
				roleRef.setRoleOid(role.getOid());
				result.addRoleRef(roleRef);
			}
		}

		return result;
	}
}
