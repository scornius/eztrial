package org.nerdizin.eztrial.xml.odm.admin;

import org.nerdizin.eztrial.xml.Namespaces;
import org.nerdizin.eztrial.xml.adapter.UserTypeAdapter;
import org.nerdizin.eztrial.xml.odm.base.OidElement;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;


public class User extends OidElement {

    @XmlAttribute(name = "UserType")
    @XmlJavaTypeAdapter(UserTypeAdapter.class)
    private UserType userType;

	@XmlElement(name = "LoginName")
	private String loginName;

    @XmlElement(name = "FirstName")
    private String firstName;

    @XmlElement(name = "LastName")
    private String lastName;

    @XmlElement(name = "Address")
    private Address address;

    @XmlElement(name = "Email")
    private String email;

    @XmlElement(name = "Phone")
    private String phone;

	@XmlElement(name = "Password", namespace = Namespaces.EZTRIAL)
	private String password;

    @XmlElement(name = "RoleRef", namespace = Namespaces.EZTRIAL)
    private List<RoleRef> roleRefs;

    @XmlAttribute(name = "active", namespace = Namespaces.EZTRIAL)
	private boolean active;


    public UserType getUserType() {
        return userType;
    }

    public void setUserType(final UserType userType) {
        this.userType = userType;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(final String loginName) {
		this.loginName = loginName;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
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

	public List<RoleRef> getRoleRefs() {
		return roleRefs;
	}

	public void setRoleRefs(final List<RoleRef> roleRefs) {
		this.roleRefs = roleRefs;
	}

	public void addRoleRef(final RoleRef roleRef) {
    	if (this.roleRefs == null) {
    		this.roleRefs = new ArrayList<>();
		}
    	this.roleRefs.add(roleRef);
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(final boolean active) {
		this.active = active;
	}
}
