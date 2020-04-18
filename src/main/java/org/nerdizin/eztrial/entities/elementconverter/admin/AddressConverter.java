package org.nerdizin.eztrial.entities.elementconverter.admin;

import org.nerdizin.eztrial.entities.admin.Address;
import org.nerdizin.eztrial.entities.elementconverter.common.OdmElementToEntityConverter;

public class AddressConverter implements OdmElementToEntityConverter<org.nerdizin.eztrial.xml.odm.admin.Address,Address> {

	@Override
	public Address convertToEntity(final org.nerdizin.eztrial.xml.odm.admin.Address address) {

		final Address result = new Address();
		result.setStreet(address.getStreetName());
		result.setCity(address.getCity());
		result.setRegion(address.getStateProv());
		result.setCountry(address.getCountry());
		result.setPostalCode(address.getPostalCode());

		return result;
	}

	@Override
	public org.nerdizin.eztrial.xml.odm.admin.Address convertToElement(final Address address) {

		final org.nerdizin.eztrial.xml.odm.admin.Address result = new org.nerdizin.eztrial.xml.odm.admin.Address();
		result.setStreetName(address.getStreet());
		result.setCity(address.getCity());
		result.setStateProv(address.getRegion());
		result.setCountry(address.getCountry());
		result.setPostalCode(address.getPostalCode());

		return result;
	}
}
