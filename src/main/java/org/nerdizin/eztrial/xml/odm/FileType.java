package org.nerdizin.eztrial.xml.odm;

public enum FileType {

    SNAPSHOT("Snapshot"),
    TRANSACTIONAL("Transactional");

    private String code;

    FileType(final String code) {
        this.code = code;
    }

    public String value() {
        return name();
    }

    public String getCode() {
        return code;
    }

    public static FileType fromCode(final String code) {
        for (final FileType fileType : values()) {
            if (fileType.getCode().equals(code)) {
                return fileType;
            }
        }
        throw new IllegalArgumentException("Unknown code: " + code);
    }
}
