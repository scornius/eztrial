package org.nerdizin.eztrial.entities.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UserTypeConverter implements AttributeConverter<UserType,String> {

	@Override
	public String convertToDatabaseColumn(final UserType userType) {
		return userType.getCode();
	}

	@Override
	public UserType convertToEntityAttribute(final String code) {
		return UserType.fromCode(code);
	}
}
