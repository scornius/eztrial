package org.nerdizin.eztrial.entities;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

	private String userName;
	private String firstName;
	private String lastName;
	private String email;

	protected User() {}

	public User(final String firstName, final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(final String firstName, final String lastName, final String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
