package org.nerdizin.eztrial.entities.admin;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.BaseEntity;
import org.nerdizin.eztrial.entities.enums.UserType;
import org.nerdizin.eztrial.entities.enums.UserTypeConverter;
import org.nerdizin.eztrial.security.Privilege;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "admin_users")
public class User extends BaseEntity {

	@Column(name = "oid", nullable = false, updatable = false, unique = true)
	private String oid;

	@Column(name = "user_name", unique = true)
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "active", nullable = false)
	private boolean active;

	@Column(name = "deleted", nullable = false)
	private boolean deleted;

	@Column(name = "locked", nullable = false)
	private boolean locked;

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
	private UserType type;

	@OneToOne
	private Address address;

	@OneToMany
	private Set<Role> roles;


	public Collection<GrantedAuthority> getAuthorities() {
		if ("admin".equals(userName)) {
			return getAdminAuthorities();
		}
		final Set<GrantedAuthority> result = new HashSet<>();
		for (final Role role : roles) {
			result.addAll(role.getPrivileges().stream()
					.filter(org.nerdizin.eztrial.entities.admin.Privilege::isValue)
					.collect(Collectors.toSet()));
		}
		return result;
	}

	private Collection<GrantedAuthority> getAdminAuthorities() {
		final Set<GrantedAuthority> result = new HashSet<>();
		for (final Privilege value : Privilege.values()) {
			result.add((GrantedAuthority) value::getKey);
		}
		return result;
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

	public UserType getType() {
		return type;
	}

	public void setType(final UserType type) {
		this.type = type;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(final Address address) {
		this.address = address;
	}

	public boolean hasAddress() {
		return address != null;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(final boolean active) {
		this.active = active;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(final boolean locked) {
		this.locked = locked;
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

	public boolean hasRoles() {
		return roles != null;
	}

	@Override
	public boolean isDeleted() {
		return deleted;
	}

	@Override
	public void setDeleted(final boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
