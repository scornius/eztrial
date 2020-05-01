package org.nerdizin.eztrial.web.converter;

import org.nerdizin.eztrial.entities.admin.Role;
import org.nerdizin.eztrial.entities.admin.User;

public class UserConverter implements Entity2UiModelConverter<User,org.nerdizin.eztrial.web.model.admin.User> {

	@Override
	public org.nerdizin.eztrial.web.model.admin.User convertToUiModel(final User entity) {

		final org.nerdizin.eztrial.web.model.admin.User result =
				new org.nerdizin.eztrial.web.model.admin.User()
			.setId(entity.getId())
			.setActive(entity.isActive())
			.setOid(entity.getOid())
			.setFirstName(entity.getFirstName())
			.setLastName(entity.getLastName())
			.setEmail(entity.getEmail())
			.setPhone(entity.getPhone())
			.setUserName(entity.getUserName());

		if (entity.getType() != null) {
			result.setType(entity.getType().getCode());
		}
		
		if (entity.getAddress() != null) {
			final AddressConverter addressConverter = new AddressConverter();
			result.setAddress(addressConverter.convertToUiModel(entity.getAddress()));
		}

		if (entity.getRoles() != null) {
			final RoleConverter roleConverter = new RoleConverter();
			for (final Role role : entity.getRoles()) {
				result.addRole(roleConverter.convertToUiModel(role));
			}
		}

		return result;
	}

	@Override
	public User convertToEntity(final org.nerdizin.eztrial.web.model.admin.User user) {
		return null;
	}
}
