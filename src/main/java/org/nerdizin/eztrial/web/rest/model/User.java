package org.nerdizin.eztrial.web.rest.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class User implements UiModel {

	private String oid;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String userType;
	private Address address;

	public String getOid() {
		return oid;
	}

	public void setOid(final String oid) {
		this.oid = oid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(final String phone) {
		this.phone = phone;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(final String userType) {
		this.userType = userType;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(final Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
