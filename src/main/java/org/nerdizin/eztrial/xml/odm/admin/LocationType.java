package org.nerdizin.eztrial.xml.odm.admin;

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

    public String value() {
        return name();
    }

    public String getCode() {
        return code;
    }

    public static LocationType fromCode(final String code) {
        for (final LocationType locationType : values()) {
            if (locationType.getCode().equals(code)) {
                return locationType;
            }
        }
        throw new IllegalArgumentException("Unknown code: " + code);
    }
}
