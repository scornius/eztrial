package org.nerdizin.eztrial.web.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PasswordChange {

	private String password1;
	private String password2;

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(final String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(final String password2) {
		this.password2 = password2;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
