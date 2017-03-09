package com.cb.model;

/**
 * @author mkhader
 *
 */
public class Email {
	public Email() {
	};

	public Email(String nmStr) {
		this.name = nmStr;
	}

	private String name;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
