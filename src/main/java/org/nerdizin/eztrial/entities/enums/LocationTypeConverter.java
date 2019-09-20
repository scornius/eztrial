package org.nerdizin.eztrial.entities.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LocationTypeConverter implements AttributeConverter<LocationType,String> {

	@Override
	public String convertToDatabaseColumn(final LocationType locationType) {
		if (locationType == null) {
			return null;
		}
		return locationType.getCode();
	}

	@Override
	public LocationType convertToEntityAttribute(final String value) {
		if (value == null) {
			return null;
		}
		return LocationType.fromCode(value);
	}
}
