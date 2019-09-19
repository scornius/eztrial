package org.nerdizin.eztrial.entities.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DataTypeConverter implements AttributeConverter<DataType,String> {

	@Override
	public String convertToDatabaseColumn(final DataType dataType) {
		return dataType.getCode();
	}

	@Override
	public DataType convertToEntityAttribute(final String code) {
		return DataType.fromCode(code);
	}
}
