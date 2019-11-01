package org.nerdizin.eztrial.web.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Address implements UiModel {

	private String street;
	private String city;
	private String region;
	private String postalCode;
	private String country;

	public String getStreet() {
		return street;
	}

	public void setStreet(final String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(final String region) {
		this.region = region;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(final String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
