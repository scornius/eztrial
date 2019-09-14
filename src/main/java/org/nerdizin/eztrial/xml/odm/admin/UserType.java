package org.nerdizin.eztrial.xml.odm.admin;

public enum UserType {

    SPONSOR("Sponsor"),
	INVESTIGATOR("Investigator"),
	LAB("Lab"),
    OTHER("Other");

    private String code;

    UserType(final String code) {
        this.code = code;
    }

    public String value() {
        return name();
    }

    public String getCode() {
        return code;
    }

    public static UserType fromCode(final String code) {
        for (final UserType fileType : values()) {
            if (fileType.getCode().equals(code)) {
                return fileType;
            }
        }
        throw new IllegalArgumentException("Unknown code: " + code);
    }

}
