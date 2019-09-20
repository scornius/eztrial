package org.nerdizin.eztrial.entities.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DataTypeConverter implements AttributeConverter<DataType,String> {

	@Override
	public String convertToDatabaseColumn(final DataType dataType) {
		if (dataType == null) {
			return null;
		}
		return dataType.getCode();
	}

	@Override
	public DataType convertToEntityAttribute(final String code) {
		if (code == null || "".equals(code)) {
			return null;
		}
		return DataType.fromCode(code);
	}
}
