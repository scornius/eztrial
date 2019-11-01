package org.nerdizin.eztrial.web.rest.converter;

import org.nerdizin.eztrial.entities.admin.Location;

public class LocationConverter implements Entity2UiModelConverter<Location,org.nerdizin.eztrial.web.rest.model.Location> {

	@Override
	public org.nerdizin.eztrial.web.rest.model.Location convertToUiModel(final Location entity) {

		final org.nerdizin.eztrial.web.rest.model.Location result = new org.nerdizin.eztrial.web.rest.model.Location();
		result.setOid(entity.getOid());
		result.setName(entity.getName());
		result.setAffix(entity.getAffix());
		result.setLabel(entity.getLabel());
		result.setActive(entity.isActive());

		if (entity.getType() != null) {
			result.setType(entity.getType().getCode());
		}

		if (entity.getAddress() != null) {
			final AddressConverter addressConverter = new AddressConverter();
			result.setAddress(addressConverter.convertToUiModel(entity.getAddress()));
		}

		return result;
	}

	@Override
	public Location convertToEntity(final org.nerdizin.eztrial.web.rest.model.Location location) {
		return null;
	}
}
