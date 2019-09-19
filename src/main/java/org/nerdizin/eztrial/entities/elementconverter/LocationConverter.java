package org.nerdizin.eztrial.entities.elementconverter;

import org.nerdizin.eztrial.entities.admin.Location;
import org.nerdizin.eztrial.entities.enums.LocationType;

public class LocationConverter implements OdmElement2EntityConverter<org.nerdizin.eztrial.xml.odm.admin.Location,Location> {

	@Override
	public Location convert2Entity(final org.nerdizin.eztrial.xml.odm.admin.Location locationElement) {

		final Location result = new Location(locationElement.getOid(),
				locationElement.getName(),
				LocationType.getByCode(locationElement.getLocationType().getCode()));

		return result;
	}

}
