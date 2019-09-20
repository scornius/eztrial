package org.nerdizin.eztrial.entities.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UserTypeConverter implements AttributeConverter<UserType,String> {

	@Override
	public String convertToDatabaseColumn(final UserType userType) {
		if (userType == null) {
			return null;
		}
		return userType.getCode();
	}

	@Override
	public UserType convertToEntityAttribute(final String code) {
		if (code == null) {
			return null;
		}
		return UserType.fromCode(code);
	}
}
