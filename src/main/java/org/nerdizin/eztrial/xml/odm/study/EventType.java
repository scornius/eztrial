package org.nerdizin.eztrial.xml.odm.study;

public enum EventType {

	SCHEDULED("Scheduled"),
	UNSCHEDULED("Unscheduled"),
	COMMON("Common");

	private String code;

	EventType(final String code) {
		this.code = code;
	}

	public String value() {
		return name();
	}

	public String getCode() {
		return code;
	}

	public static EventType fromCode(final String code) {
		for (final EventType eventType : values()) {
			if (eventType.getCode().equals(code)) {
				return eventType;
			}
		}
		throw new IllegalArgumentException("Unknown code: " + code);
	}

}
