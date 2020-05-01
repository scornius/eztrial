package org.nerdizin.eztrial.xml.odm.study.def;

public enum DataType {
	
	INTEGER("integer"),
	FLOAT("float"),
	DATE("date"),
	DATE_TIME("datetime"),
	TIME("time"),
	TEXT("text"),
	STRING("string"),
	DOUBLE("double"),
	URI("URI"),
	BOOLEAN("boolean"),
	HEX_BINARY("hexBinary"),
	BASE64_BINARY("base64Binary"),
	HEX_FLOAT("hexFloat"),
	BASE64_FLOAT("base64Float"),
	PARTIAL_DATE("partialDate"),
	PARTIAL_TIME("partialTime"),
	PARTIAL_DATE_TIME("partialDatetime"),
	DURATION_DATE_TIME("durationDatetime"),
	INTERVAL_DATE_TIME("intervalDatetime"),
	INCOMPLETE_DATE_TIME("incompleteDatetime"),
	INCOMPLETE_DATE("incompleteDate"),
	INCOMPLETE_TIME("incompleteTime");

	private String code;

	DataType(final String code) {
		this.code = code;
	}

	public String value() {
		return name();
	}

	public String getCode() {
		return code;
	}

	public static DataType fromCode(final String code) {
		for (final DataType dataType : values()) {
			if (dataType.getCode().equals(code)) {
				return dataType;
			}
		}
		throw new IllegalArgumentException("Unknown code: " + code);
	}
}
