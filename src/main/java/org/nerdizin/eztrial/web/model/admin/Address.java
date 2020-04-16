package org.nerdizin.eztrial.web.model.admin;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.web.model.UiModel;

public class Address implements UiModel {

	private String street;
	private String city;
	private String region;
	private String postalCode;
	private String country;

	public String getStreet() {
		return street;
	}

	public Address setStreet(String street) {
		this.street = street;
		return this;
	}

	public String getCity() {
		return city;
	}

	public Address setCity(String city) {
		this.city = city;
		return this;
	}

	public String getRegion() {
		return region;
	}

	public Address setRegion(String region) {
		this.region = region;
		return this;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public Address setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public Address setCountry(String country) {
		this.country = country;
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
