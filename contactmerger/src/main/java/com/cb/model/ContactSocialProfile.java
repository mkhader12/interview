package com.cb.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactSocialProfile implements Serializable, Comparable<ContactSocialProfile> {
	/**
	* 
	*/
	private static final long serialVersionUID = -8208396103090919408L;
	private String network;
	private String url;

	@JsonProperty(required = false)
	public String getNetwork() {
		return network;
	}

	@JsonProperty(required = false)
	public void setNetwork(String network) {
		this.network = network;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int compareTo(ContactSocialProfile inObj) {
		if (inObj != null) {
			if (this.getUrl() != null && inObj.getUrl() != null && inObj.getUrl().equalsIgnoreCase(this.getUrl())) {

				if (this.getNetwork() != null && inObj.getNetwork() != null)
					return inObj.getNetwork().compareTo(this.getNetwork());
			}
		}
		return -1;
	}

}
