package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.admin.Location;
import org.nerdizin.eztrial.entities.enums.LocationType;

public class LocationConverter implements OdmElement2EntityConverter<org.nerdizin.eztrial.xml.odm.admin.Location,Location> {

	@Override
	public Location convert2Entity(final org.nerdizin.eztrial.xml.odm.admin.Location location) {

		final Location result = new Location();
		result.setOid(location.getOid());
		result.setName(location.getName());

		if (location.getLocationType() != null) {
			result.setType(LocationType.fromCode(location.getLocationType().getCode()));
		}

		return result;
	}

	@Override
	public org.nerdizin.eztrial.xml.odm.admin.Location convert2Element(final Location location) {

		final org.nerdizin.eztrial.xml.odm.admin.Location result =
				new org.nerdizin.eztrial.xml.odm.admin.Location();
		result.setOid(location.getOid());
		result.setName(location.getName());

		if (location.getType() != null) {
			result.setLocationType(org.nerdizin.eztrial.xml.odm.admin.LocationType.fromCode(location.getType().getCode()));
		}

		return result;
	}
}
