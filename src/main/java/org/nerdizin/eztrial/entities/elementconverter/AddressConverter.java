package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.admin.Address;

public class AddressConverter implements OdmElement2EntityConverter<org.nerdizin.eztrial.xml.odm.admin.Address,Address> {

	@Override
	public Address convert2Entity(final org.nerdizin.eztrial.xml.odm.admin.Address address) {

		final Address result = new Address();
		result.setStreet(address.getStreetName());
		result.setCity(address.getCity());
		result.setRegion(address.getStateProv());
		result.setCountry(address.getCountry());
		result.setPostalCode(address.getPostalCode());

		return result;
	}
}
