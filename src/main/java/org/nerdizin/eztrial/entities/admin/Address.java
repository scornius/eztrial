package org.nerdizin.eztrial.entities.admin;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "admin_addresses")
public class Address extends BaseEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;

	@Column(name = "region")
	private String region;

	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "country")
	private String country;

	public Address() {}

	public String getStreet() {
		return street;
	}

	public Address setStreet(final String street) {
		this.street = street;
		return this;
	}

	public String getCity() {
		return city;
	}

	public Address setCity(final String city) {
		this.city = city;
		return this;
	}

	public String getRegion() {
		return region;
	}

	public Address setRegion(final String region) {
		this.region = region;
		return this;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public Address setPostalCode(final String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public Address setCountry(final String country) {
		this.country = country;
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
