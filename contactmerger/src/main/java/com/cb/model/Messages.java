package com.cb.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Messages {

	private String messageId;

	@JsonProperty(value = "message_id", required = true)
	public String getMessageId() {
		return messageId;
	}

	@JsonProperty(value = "message_id", required = true)
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	@JsonProperty(value = "user_id", required = true)
	public String getUserId() {
		return userId;
	}

	@JsonProperty(value = "user_id", required = true)
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@JsonProperty(value = "sent_date", required = true)
	public String getSentDate() {
		return sentDate;
	}

	@JsonProperty(value = "sent_date", required = true)
	public void setSentDate(String sentDate) {
		this.sentDate = sentDate;
	}

	@JsonProperty(value = "from", required = true)
	public Email getFromAddress() {
		return from;
	}

	@JsonProperty(value = "from", required = true)
	public void setFromAddress(Email fromAddress) {
		this.from = fromAddress;
	}

	@JsonProperty(value = "to", required = true)
	public List<Email> getToAddress() {
		return toAddress;
	}

	@JsonProperty(value = "to", required = true)
	public void setToAddress(List<Email> toAddress) {
		this.toAddress = toAddress;
	}

	private String userId;
	private String sentDate;
	private Email from;
	private List<Email> toAddress;
	private String body;

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
