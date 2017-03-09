package com.cb.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactPhoneNumber implements Serializable, Comparable<ContactPhoneNumber> {
	public ContactPhoneNumber() {

	}

	public ContactPhoneNumber(String phone) {
		setPhoneNumber(phone);
	}

	@Override
	public boolean equals(Object obj) {
		ContactPhoneNumber inPhone = (ContactPhoneNumber) obj;

		if (this.getPhoneNumber() != null && inPhone.getPhoneNumber() != null
				&& this.getPhoneNumber().equals(inPhone.getPhoneNumber())) {
			return (this.getType() != null && inPhone.getType() != null && this.getType().equals(inPhone.getType()));
		}
		return false;
	}

	/**
	* 
	*/
	private static final long serialVersionUID = 3366836867317070637L;

	@JsonProperty(value = "phone_number", required = false)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@JsonProperty(value = "phone_number", required = false)
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@JsonProperty(required = false)
	public String getType() {
		return type;
	}

	@JsonProperty(required = false)
	public void setType(String type) {
		this.type = type;
	}

	private String phoneNumber;
	private String type;

	public int compareTo(ContactPhoneNumber inObj) {
		if (inObj != null) {
			if (this.getPhoneNumber() != null && inObj.getPhoneNumber() != null
					&& inObj.getPhoneNumber().equals(this.getPhoneNumber())) {

				if (this.getType() != null && inObj.getType() != null)
					return inObj.getType().compareTo(this.getType());
			}
		}
		return -1;
	}

}
