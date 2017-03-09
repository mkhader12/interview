package com.cb.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactAddress implements Serializable, Comparable<ContactAddress> {
	/**
	* 
	*/
	private static final long serialVersionUID = 8418400393773436148L;

	@JsonProperty(required = false)
	public String getStreet1() {
		return street1;
	}

	@JsonProperty(required = false)
	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	@JsonProperty(required = false)
	public String getStreet2() {
		return street2;
	}

	@JsonProperty(required = false)
	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	@JsonProperty(required = false)
	public String getCity() {
		return city;
	}

	@JsonProperty(required = false)
	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty(required = false)
	public String getState() {
		return state;
	}

	@JsonProperty(required = false)
	public void setState(String state) {
		this.state = state;
	}

	@JsonProperty(required = false)
	public String getZip() {
		return zip;
	}

	@JsonProperty(required = false)
	public void setZip(String zip) {
		this.zip = zip;
	}

	@JsonProperty(required = false)
	public String getCountry() {
		return country;
	}

	@JsonProperty(required = false)
	public void setCountry(String country) {
		this.country = country;
	}

	private String street1;
	private String street2;
	private String city;
	private String state;
	private String zip;
	private String country;

	public void merge(Mergeable in) {
		if (in != null && in instanceof Contact) {
			Contact inObj = (Contact) in;
		}
	}

	public int compareTo(ContactAddress in) {
		if (in != null) {
			int res = (in.getStreet1() != null) ? this.getStreet1().compareTo(in.getStreet1()) : -1;
			if (res == 0) {
				res = (in.getStreet2() != null) ? this.getStreet2().compareTo(in.getStreet2()) : -1;
				if (res == 0) {
					res = (in.getCity() != null) ? this.getCity().compareTo(in.getCity()) : -1;
					if (res == 0) {
						res = (in.getState() != null) ? this.getState().compareTo(in.getState()) : -1;
						if (res == 0) {

							res = (in.getZip() != null) ? this.getZip().compareTo(in.getZip()) : -1;
							if (res == 0) {

								res = (in.getCountry() != null) ? this.getCountry().compareTo(in.getCountry()) : -1;
							}
						}
					}
				}
			}
			return res;

		}
		return 0;
	}
}
