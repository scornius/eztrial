package org.nerdizin.eztrial.entities.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class EventTypeConverter implements AttributeConverter<EventType,String> {

	@Override
	public String convertToDatabaseColumn(final EventType eventType) {
		if (eventType == null) {
			return null;
		}
		return eventType.getCode();
	}

	@Override
	public EventType convertToEntityAttribute(final String code) {
		if (code == null) {
			return null;
		}
		return EventType.getByCode(code);
	}
}
