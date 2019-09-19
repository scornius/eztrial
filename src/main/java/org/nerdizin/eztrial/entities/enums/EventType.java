package org.nerdizin.eztrial.entities.enums;

public enum EventType {

	SCHEDULED("Scheduled"),
	UNSCHEDULED("Unscheduled"),
	COMMON("Common");

	private String code;

	EventType(final String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static EventType getByCode(final String code) {
		for (final EventType eventType : values()) {
			if (eventType.getCode().equalsIgnoreCase(code)) {
				return eventType;
			}
		}
		throw new IllegalArgumentException(String.format("Unknown EventType code %s", code));
	}
}
