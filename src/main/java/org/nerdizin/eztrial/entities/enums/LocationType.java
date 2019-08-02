package org.nerdizin.eztrial.entities.enums;

public enum LocationType {

	SPONSOR("SPONSOR"),
	SITE("SITE"),
	CRO("CRO"),
	LAB("Lab"),
	OTHER("Other");

	private String value;

	LocationType( final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static LocationType getByValue(final String value) {
		for (final LocationType locationType : values()) {
			if (locationType.getValue().equalsIgnoreCase(value)) {
				return locationType;
			}
		}
		throw new IllegalArgumentException(String.format("Unknown Location value %s", value));
	}
}
