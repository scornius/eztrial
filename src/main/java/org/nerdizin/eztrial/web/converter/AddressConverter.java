package org.nerdizin.eztrial.web.converter;

import org.nerdizin.eztrial.entities.admin.Address;

public class AddressConverter implements Entity2UiModelConverter<Address,org.nerdizin.eztrial.web.model.admin.Address> {

	@Override
	public org.nerdizin.eztrial.web.model.admin.Address convertToUiModel(final Address entity) {

		return new org.nerdizin.eztrial.web.model.admin.Address()
			.setCity(entity.getCity())
			.setCountry(entity.getCountry())
			.setPostalCode(entity.getPostalCode())
			.setRegion(entity.getRegion())
			.setStreet(entity.getStreet());
	}

	@Override
	public Address convertToEntity(final org.nerdizin.eztrial.web.model.admin.Address address) {
		return null;
	}
}
