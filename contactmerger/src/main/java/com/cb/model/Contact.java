package com.cb.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact extends Mergeable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7251159714659062237L;

	private String fullName;
	private String prefix;
	private String firstName;
	private String middleName;
	private String lastName;
	private String suffix;
	private String nickName;
	private String title;
	private String company;
	private List<String> emails;
	private List<ContactAddress> addresses;
	private List<ContactPhoneNumber> phoneNumbers;
	private List<ContactSocialProfile> socialProfile;
	private List<String> urls;

	@Override
	public boolean equals(Object obj) {
		Contact inCnt = (Contact) obj;
		// First compare the first name
		if (firstName != null && inCnt.getFirstName() != null && firstName.equalsIgnoreCase(inCnt.getFirstName())) {
			// Compare the last name
			if (lastName != null && inCnt.getLastName() != null && lastName.equalsIgnoreCase(inCnt.getLastName())) {
				if (comparePhoneNumbers(inCnt)) {
					return true;
				} else {
					return compareEmails(inCnt);
				}
			}

		}
		return false;
	}

	private boolean comparePhoneNumbers(Contact inCnt) {
		List<ContactPhoneNumber> phones = this.getPhoneNumbers();
		List<ContactPhoneNumber> inPhones = inCnt.getPhoneNumbers();
		if (phones == null || phones.isEmpty() || inPhones == null || inPhones.isEmpty()) {
			return false;
		} else {
			for (int i = 0; i < phones.size();i++) {
				try {
					ContactPhoneNumber phone = phones.get(i);
					ContactPhoneNumber inPhone = inPhones.get(i);
					return phone.equals(inPhone);
				} catch (Exception e) {
					// No equal element
					// No need to do anything
					break;
				}
			}

		}
		return false;
	}

	private boolean compareEmails(Contact inCnt) {
		List<String> emails = this.getEmails();
		List<String> inEmail = inCnt.getEmails();
		String emailStr = null;
		String inEmailStr = null;
		for (int i = 0; i < emails.size(); i++) {
			try {
				emailStr = emails.get(i);
				inEmailStr = inEmail.get(i);
				if (emailStr != null && inEmailStr != null && emailStr.equalsIgnoreCase(inEmailStr)) {
					return true;
				}
			} catch (Exception e) {
				// No equal element
				// No need to do anything
				break;
			}
		}
		return false;
	}

	@JsonProperty(value = "full_name", required = false)
	public String getFullName() {
		return fullName;
	}

	@JsonProperty(value = "full_name", required = false)
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@JsonProperty(required = false)
	public String getPrefix() {
		return prefix;
	}

	@JsonProperty(required = false)
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	@JsonProperty(value = "first_name", required = false)
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty(value = "first_name", required = false)
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty(value = "middle_name", required = false)
	public String getMiddleName() {
		return middleName;
	}

	@JsonProperty(value = "middle_name", required = false)
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@JsonProperty(value = "last_name", required = false)
	public String getLastName() {
		return lastName;
	}

	@JsonProperty(value = "last_name", required = false)
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty(required = false)
	public String getSuffix() {
		return suffix;
	}

	@JsonProperty(required = false)
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@JsonProperty(value = "nick_name", required = false)
	public String getNickName() {
		return nickName;
	}

	@JsonProperty(value = "nick_name", required = false)
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@JsonProperty(required = false)
	public String getTitle() {
		return title;
	}

	@JsonProperty(required = false)
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty(required = false)
	public String getCompany() {
		return company;
	}

	@JsonProperty(required = false)
	public void setCompany(String company) {
		this.company = company;
	}

	@JsonProperty(required = false)
	public List<String> getEmails() {
		return emails;
	}

	@JsonProperty(required = false)
	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	@JsonProperty(required = false)
	public List<ContactAddress> getAddresses() {
		return addresses;
	}

	@JsonProperty(required = false)
	public void setAddresses(List<ContactAddress> addresses) {
		this.addresses = addresses;
	}

	@JsonProperty(value = "phone_numbers", required = false)
	public List<ContactPhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	@JsonProperty(value = "phone_numbers", required = false)
	public void setPhoneNumbers(List<ContactPhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@JsonProperty(value = "social_profiles", required = false)
	public List<ContactSocialProfile> getSocialProfile() {
		return socialProfile;
	}

	@JsonProperty(value = "social_profiles", required = false)
	public void setSocialProfile(List<ContactSocialProfile> socialProfile) {
		this.socialProfile = socialProfile;
	}

	@JsonProperty(required = false)
	public List<String> getUrls() {
		return urls;
	}

	@JsonProperty(required = false)
	public void setUrls(List<String> urls) {
		this.urls = urls;
	}

	@Override
	public void merge(Mergeable in) {
		if (in != null && in instanceof Contact) {
			Contact inObj = (Contact) in;

			this.fullName = (inObj.getFullName() != null ? inObj.getFullName() : this.fullName);
			this.prefix = (inObj.getPrefix() != null ? inObj.getPrefix() : this.prefix);
			this.firstName = (inObj.getFirstName() != null ? inObj.getFirstName() : this.firstName);
			this.middleName = (inObj.getMiddleName() != null ? inObj.getMiddleName() : this.middleName);
			this.lastName = (inObj.getLastName() != null ? inObj.getLastName() : this.lastName);
			this.suffix = (inObj.getSuffix() != null ? inObj.getSuffix() : this.suffix);
			this.nickName = (inObj.getNickName() != null ? inObj.getNickName() : this.nickName);
			this.title = (inObj.getTitle() != null ? inObj.getTitle() : this.title);
			this.company = (inObj.getCompany() != null ? inObj.getCompany() : this.company);

			Object[] newArray = null;
			if (this.getEmails() != null && inObj.getEmails() != null) {
				newArray = mergeObjectList(this.getEmails().toArray(), inObj.getEmails().toArray());
				this.setEmails(Arrays.asList(Arrays.copyOf(newArray, newArray.length, String[].class)));
			}
			if (this.getAddresses() != null && inObj.getAddresses() != null) {
				newArray = mergeObjectList(this.getAddresses().toArray(), inObj.getAddresses().toArray());
				this.setAddresses(Arrays.asList(Arrays.copyOf(newArray, newArray.length, ContactAddress[].class)));
			}
			if (this.getPhoneNumbers() != null && inObj.getPhoneNumbers() != null) {
				newArray = mergeObjectList(this.getPhoneNumbers().toArray(), inObj.getPhoneNumbers().toArray());
				this.setPhoneNumbers(
						Arrays.asList(Arrays.copyOf(newArray, newArray.length, ContactPhoneNumber[].class)));
			}

			if (this.getUrls() != null && inObj.getUrls() != null) {
				newArray = mergeObjectList(this.getUrls().toArray(), inObj.getUrls().toArray());
				this.setUrls(Arrays.asList(Arrays.copyOf(newArray, newArray.length, String[].class)));
			}
		}
	}

	private Object[] mergeObjectList(Object[] existingObj, Object[] newObj) {
		Set<Object> mySet = new TreeSet<Object>();
		if (newObj != null && newObj.length > 0)
			mySet.addAll(Arrays.asList(newObj));
		if (existingObj != null && existingObj.length > 0)
			mySet.addAll(Arrays.asList(existingObj));
		return mySet.toArray();
	}
}
