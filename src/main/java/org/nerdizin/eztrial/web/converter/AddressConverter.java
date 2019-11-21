package org.nerdizin.eztrial.web.converter;

import org.nerdizin.eztrial.entities.admin.Address;

public class AddressConverter implements Entity2UiModelConverter<Address,org.nerdizin.eztrial.web.model.admin.Address> {

	@Override
	public org.nerdizin.eztrial.web.model.admin.Address convertToUiModel(final Address entity) {

		final org.nerdizin.eztrial.web.model.admin.Address result =
				new org.nerdizin.eztrial.web.model.admin.Address();
		result.setCity(entity.getCity());
		result.setCountry(entity.getCountry());
		result.setPostalCode(entity.getPostalCode());
		result.setRegion(entity.getRegion());
		result.setStreet(entity.getStreet());
		return result;
	}

	@Override
	public Address convertToEntity(final org.nerdizin.eztrial.web.model.admin.Address address) {
		return null;
	}
}
