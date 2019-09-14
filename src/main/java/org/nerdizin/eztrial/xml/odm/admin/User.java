package org.nerdizin.eztrial.xml.odm.admin;

import org.nerdizin.eztrial.xml.adapter.UserTypeAdapter;
import org.nerdizin.eztrial.xml.odm.Namespaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class User {

    @XmlAttribute(name = "OID")
    private String oid;

    @XmlAttribute(name = "UserType")
    @XmlJavaTypeAdapter(UserTypeAdapter.class)
    private UserType userType;

    @XmlElement(name = "FirstName", namespace = Namespaces.ODM)
    private String firstName;

    @XmlElement(name = "LastName", namespace = Namespaces.ODM)
    private String lastName;

    @XmlElement(name = "Address", namespace = Namespaces.ODM)
    private Address address;

    @XmlElement(name = "Email", namespace = Namespaces.ODM)
    private String email;

    @XmlElement(name = "Phone", namespace = Namespaces.ODM)
    private String phone;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
