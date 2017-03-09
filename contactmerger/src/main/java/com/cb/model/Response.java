package com.cb.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response implements Serializable {
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

	@JsonIgnore
	public String getDebugInfo() {
		return debugInfo;
	}

	@JsonIgnore
	public void setDebugInfo(String debugInfo) {
		this.debugInfo = debugInfo;
	}

	@JsonProperty(value = "contact_count", required = true)
	public String getContactCount() {
		return contactCount;
	}

	@JsonProperty(value = "contact_count", required = true)
	public void setContactCount(String contactCount) {
		this.contactCount = contactCount;
	}

	@JsonProperty(required = true)
	public List<Results> getResults() {
		return results;
	}

	@JsonProperty(required = true)
	public void setResults(List<Results> results) {
		this.results = results;
	}

	private String requestId;
	private String debugInfo;
	private String contactCount;
	@JsonProperty("results")
	private List<Results> results;
}
