package org.nerdizin.eztrial.entities.admin;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.BaseEntity;
import org.nerdizin.eztrial.entities.enums.UserType;
import org.nerdizin.eztrial.entities.enums.UserTypeConverter;
import org.nerdizin.eztrial.util.Privilege;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "admin_users")
public class User extends BaseEntity {

	@Column(name = "oid", nullable = false, updatable = false, unique = true)
	private String oid;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "active", nullable = false)
	private boolean active;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "user_type")
	@Convert(converter = UserTypeConverter.class)
	private UserType userType;

	@OneToOne
	private Address address;

	@OneToMany
	private Set<Role> roles;


	public boolean hasPrivilege(final Privilege privilege) {
		for (final Role role : roles) {
			final List<org.nerdizin.eztrial.entities.admin.Privilege> privileges = role.getPrivileges();
			if (privileges != null) {
				for (org.nerdizin.eztrial.entities.admin.Privilege tmpPriv : privileges) {
					if (privilege.getKey().equals(tmpPriv.getOid())) {
						return true;
					}
				}
			}
		}
		return false;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
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

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(final UserType userType) {
		this.userType = userType;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(final Address address) {
		this.address = address;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(final boolean active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(final Set<Role> roles) {
		this.roles = roles;
	}

	public void addRole(final Role role) {
		if (this.roles == null) {
			this.roles = new HashSet<>();
		}
		this.roles.add(role);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
