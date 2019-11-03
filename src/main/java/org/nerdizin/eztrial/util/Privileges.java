package org.nerdizin.eztrial.util;

public enum Privileges {
	USER_CREATE("user.create"),
	USER_EDIT("user.edit"),
	USER_DELETE("user.delete");

	private String key;

	Privileges(final String key) {
		this.key = key;
	}
}
