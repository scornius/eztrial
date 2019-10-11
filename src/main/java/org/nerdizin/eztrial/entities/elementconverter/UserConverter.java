package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.xml.odm.admin.UserType;

public class UserConverter implements OdmElementToEntityConverter<org.nerdizin.eztrial.xml.odm.admin.User,User> {

	@Override
	public User convertToEntity(final org.nerdizin.eztrial.xml.odm.admin.User user) {

		final User result = new User();
		result.setOid(user.getOid());
		result.setFirstName(user.getFirstName());
		result.setLastName(user.getLastName());
		result.setPhone(user.getPhone());
		result.setEmail(user.getEmail());

		if (user.getUserType() != null) {
			result.setUserType(org.nerdizin.eztrial.entities.enums.UserType.fromCode(user.getUserType().getCode()));
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
		result.setFirstName(user.getFirstName());
		result.setLastName(user.getLastName());
		result.setPhone(user.getPhone());
		result.setEmail(user.getEmail());

		if (user.getUserType() != null) {
			result.setUserType(UserType.fromCode(user.getUserType().getCode()));
		}

		if (user.getAddress() != null) {
			final AddressConverter addressConverter = new AddressConverter();
			result.setAddress(addressConverter.convertToElement(user.getAddress()));
		}

		return result;
	}
}
