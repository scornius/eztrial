package org.nerdizin.eztrial.entities.enums;

public enum DataType {

	INTEGER(org.nerdizin.eztrial.entities.study.data.DataType.INTEGER),
	FLOAT(org.nerdizin.eztrial.entities.study.data.DataType.FLOAT),
	DATE(org.nerdizin.eztrial.entities.study.data.DataType.DATE),
	DATE_TIME(org.nerdizin.eztrial.entities.study.data.DataType.DATE_TIME),
	TIME(org.nerdizin.eztrial.entities.study.data.DataType.TIME),
	TEXT(org.nerdizin.eztrial.entities.study.data.DataType.TEXT),
	STRING(org.nerdizin.eztrial.entities.study.data.DataType.STRING),
	DOUBLE(org.nerdizin.eztrial.entities.study.data.DataType.DOUBLE),
	URI(org.nerdizin.eztrial.entities.study.data.DataType.URI),
	BOOLEAN(org.nerdizin.eztrial.entities.study.data.DataType.BOOLEAN),
	HEX_BINARY(org.nerdizin.eztrial.entities.study.data.DataType.HEX_BINARY),
	BASE64_BINARY(org.nerdizin.eztrial.entities.study.data.DataType.BASE64_BINARY),
	HEX_FLOAT(org.nerdizin.eztrial.entities.study.data.DataType.HEX_FLOAT),
	BASE64_FLOAT(org.nerdizin.eztrial.entities.study.data.DataType.BASE64_FLOAT),
	PARTIAL_DATE(org.nerdizin.eztrial.entities.study.data.DataType.PARTIAL_DATE),
	PARTIAL_TIME(org.nerdizin.eztrial.entities.study.data.DataType.PARTIAL_TIME),
	PARTIAL_DATE_TIME(org.nerdizin.eztrial.entities.study.data.DataType.PARTIAL_DATE_TIME),
	DURATION_DATE_TIME(org.nerdizin.eztrial.entities.study.data.DataType.DURATION_DATE_TIME),
	INTERVAL_DATE_TIME(org.nerdizin.eztrial.entities.study.data.DataType.INTERVAL_DATE_TIME),
	INCOMPLETE_DATE_TIME(org.nerdizin.eztrial.entities.study.data.DataType.INCOMPLETE_DATE_TIME),
	INCOMPLETE_DATE(org.nerdizin.eztrial.entities.study.data.DataType.INCOMPLETE_DATE),
	INCOMPLETE_TIME(org.nerdizin.eztrial.entities.study.data.DataType.INCOMPLETE_TIME);

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
