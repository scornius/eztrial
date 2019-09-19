package org.nerdizin.eztrial.entities.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LocationTypeConverter implements AttributeConverter<LocationType,String> {

	@Override
	public String convertToDatabaseColumn(final LocationType locationType) {
		return locationType.getCode();
	}

	@Override
	public LocationType convertToEntityAttribute(final String value) {
		return LocationType.getByCode(value);
	}
}
