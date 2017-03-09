package com.cb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request implements Serializable {
	public Request() {
	};

	public Request(String reqId) {
		this.requestId = reqId;
	}
	public Request(String reqId, Messages inputMsg) {
		this.requestId = reqId;
		this.messages = new ArrayList<Messages>();
		this.messages.add(inputMsg);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4715724614501407020L;

	@JsonProperty(value = "request_id", required = true)
	public String getRequestId() {
		return requestId;
	}

	@JsonProperty(value = "request_id", required = true)
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public List<Messages> getMessages() {
		return messages;
	}

	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}
	public void addMessage (Messages aMsg)
	{
		if (messages == null)
		{
			messages = new ArrayList<Messages>();
		}
		messages.add(aMsg);
	}

	protected String requestId;
	protected List<Messages> messages;

}
