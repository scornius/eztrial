package org.nerdizin.eztrial.entities.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class EventTypeConverter implements AttributeConverter<EventType,String> {

	@Override
	public String convertToDatabaseColumn(final EventType eventType) {
		return eventType.getCode();
	}

	@Override
	public EventType convertToEntityAttribute(final String code) {
		return EventType.getByCode(code);
	}
}
