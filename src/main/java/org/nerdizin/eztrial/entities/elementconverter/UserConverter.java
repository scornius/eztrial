package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.xml.odm.admin.UserType;

public class UserConverter implements OdmElement2EntityConverter<org.nerdizin.eztrial.xml.odm.admin.User,User> {

	@Override
	public User convert2Entity(final org.nerdizin.eztrial.xml.odm.admin.User user) {

		final User result = new User();
		result.setFirstName(user.getFirstName());
		result.setLastName(user.getLastName());
		result.setPhone(user.getPhone());
		result.setEmail(user.getEmail());
		result.setUserType(org.nerdizin.eztrial.entities.enums.UserType.fromCode(user.getUserType().getCode()));

		if (user.getAddress() != null) {
			final AddressConverter addressConverter = new AddressConverter();
			result.setAddress(addressConverter.convert2Entity(user.getAddress()));
		}

		return result;
	}

	@Override
	public org.nerdizin.eztrial.xml.odm.admin.User convert2Element(final User user) {

		final org.nerdizin.eztrial.xml.odm.admin.User result = new org.nerdizin.eztrial.xml.odm.admin.User();
		result.setOid(user.getOid());
		result.setFirstName(user.getFirstName());
		result.setLastName(user.getLastName());
		result.setPhone(user.getPhone());
		result.setEmail(user.getEmail());
		result.setUserType(UserType.fromCode(user.getUserType().getCode()));

		if (user.getAddress() != null) {
			final AddressConverter addressConverter = new AddressConverter();
			result.setAddress(addressConverter.convert2Element(user.getAddress()));
		}

		return result;
	}
}
