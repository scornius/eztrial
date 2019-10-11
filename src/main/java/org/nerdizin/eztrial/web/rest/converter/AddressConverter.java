package org.nerdizin.eztrial.web.rest.converter;

import org.nerdizin.eztrial.entities.admin.Address;

public class AddressConverter implements Entity2UiModelConverter<Address,org.nerdizin.eztrial.web.rest.model.Address> {

	@Override
	public org.nerdizin.eztrial.web.rest.model.Address convertToUiModel(final Address entity) {

		final org.nerdizin.eztrial.web.rest.model.Address result =
				new org.nerdizin.eztrial.web.rest.model.Address();
		result.setCity(entity.getCity());
		result.setCountry(entity.getCountry());
		result.setPostalCode(entity.getPostalCode());
		result.setRegion(entity.getRegion());
		result.setStreet(entity.getStreet());
		return result;
	}

	@Override
	public Address convertToEntity(final org.nerdizin.eztrial.web.rest.model.Address address) {
		return null;
	}
}
