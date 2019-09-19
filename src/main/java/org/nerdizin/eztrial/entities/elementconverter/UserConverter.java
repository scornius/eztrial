package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.admin.User;

public class UserConverter implements OdmElement2EntityConverter<org.nerdizin.eztrial.xml.odm.admin.User,User> {

	@Override
	public User convert2Entity(final org.nerdizin.eztrial.xml.odm.admin.User user) {

		final User result = new User(user.getFirstName(), user.getLastName(), user.getEmail());
		user.setPhone(user.getPhone());

		return result;
	}
}
