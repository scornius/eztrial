package org.nerdizin.eztrial.web.converter;

import org.nerdizin.eztrial.entities.admin.Role;
import org.nerdizin.eztrial.entities.admin.User;

public class UserConverter implements Entity2UiModelConverter<User,org.nerdizin.eztrial.web.model.User> {

	@Override
	public org.nerdizin.eztrial.web.model.User convertToUiModel(final User entity) {

		final org.nerdizin.eztrial.web.model.User result =
				new org.nerdizin.eztrial.web.model.User();
		result.setId(entity.getId());
		result.setOid(entity.getOid());
		result.setFirstName(entity.getFirstName());
		result.setLastName(entity.getLastName());
		result.setEmail(entity.getEmail());
		result.setPhone(entity.getPhone());
		result.setUserName(entity.getUserName());
		if (entity.getUserType() != null) {
			result.setType(entity.getUserType().getCode());
		}
		
		if (entity.getAddress() != null) {
			final AddressConverter addressConverter = new AddressConverter();
			result.setAddress(addressConverter.convertToUiModel(entity.getAddress()));
		}

		if (entity.getRoles() != null) {
			for (final Role role : entity.getRoles()) {
				result.addRole(role.getOid());
			}
		}

		return result;
	}

	@Override
	public User convertToEntity(final org.nerdizin.eztrial.web.model.User user) {
		return null;
	}
}
