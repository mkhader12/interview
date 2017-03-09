package com.cb.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Results implements Serializable {

	@JsonProperty(value = "user_id", required = true)
	public String getUserId() {
		return UserId;
	}

	@JsonProperty(value = "user_id", required = true)
	public void setUserId(String userId) {
		UserId = userId;
	}

	@JsonProperty(value = "message_id", required = true)
	public String getMessageId() {
		return messageId;
	}

	@JsonProperty(value = "message_id", required = true)
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@JsonProperty(value = "signature_blocks", required = true)
	public List<String> getSignatureBlocks() {
		return signatureBlocks;
	}

	@JsonProperty(value = "signature_blocks", required = true)
	public void setSignatureBlocks(List<String> signatureBlocks) {
		this.signatureBlocks = signatureBlocks;
	}

	@JsonProperty(value = "result_code", required = true)
	public String getResultCode() {
		return resultCode;
	}

	@JsonProperty(value = "result_code", required = true)
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7054930701110492478L;
	private String UserId;
	private String messageId;
	private List<Contact> contacts;
	private List<String> signatureBlocks;
	private String resultCode;

}
