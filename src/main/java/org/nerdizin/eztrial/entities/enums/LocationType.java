package org.nerdizin.eztrial.entities.enums;

public enum LocationType {

	SPONSOR("Sponsor"),
	SITE("Site"),
	CRO("CRO"),
	LAB("Lab"),
	OTHER("Other");

	private String code;

	LocationType(final String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static LocationType fromCode(final String code) {
		for (final LocationType locationType : values()) {
			if (locationType.getCode().equalsIgnoreCase(code)) {
				return locationType;
			}
		}
		throw new IllegalArgumentException(String.format("Unknown Location code %s", code));
	}
}
