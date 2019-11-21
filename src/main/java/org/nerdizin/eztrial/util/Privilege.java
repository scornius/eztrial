package org.nerdizin.eztrial.util;

public enum Privilege {
	USER_CREATE("user.create"),
	USER_EDIT("user.edit"),
	USER_DELETE("user.delete"),
	USER_LIST("user.list")
	;

	private String key;

	Privilege(final String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	@Override
	public String toString() {
		return key;
	}
}
