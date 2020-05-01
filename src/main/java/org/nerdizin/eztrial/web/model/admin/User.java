package org.nerdizin.eztrial.web.model.admin;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.web.model.UiModel;
import org.nerdizin.eztrial.web.validator.PhoneNumberConstraint;

import java.util.HashSet;
import java.util.Set;

public class User implements UiModel {

	private long id;
	private boolean active;
	private String oid;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;

	@PhoneNumberConstraint
	private String phone;

	private String type;
	private Address address;
	private Set<Role> roles;

	public long getId() {
		return id;
	}

	public User setId(long id) {
		this.id = id;
		return this;
	}

	public boolean isActive() {
		return active;
	}

	public User setActive(boolean active) {
		this.active = active;
		return this;
	}

	public String getOid() {
		return oid;
	}

	public User setOid(String oid) {
		this.oid = oid;
		return this;
	}

	public String getUserName() {
		return userName;
	}

	public User setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public User setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getType() {
		return type;
	}

	public User setType(String type) {
		this.type = type;
		return this;
	}

	public Address getAddress() {
		return address;
	}

	public User setAddress(Address address) {
		this.address = address;
		return this;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public User setRoles(Set<Role> roles) {
		this.roles = roles;
		return this;
	}

	public void addRole(final Role role) {
		if (this.roles == null) {
			this.roles = new HashSet<>();
		}
		this.roles.add(role);
	}

	public boolean hasRole(final Role role) {
		if (roles == null) {
			return false;
		}
		return roles.contains(role);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
