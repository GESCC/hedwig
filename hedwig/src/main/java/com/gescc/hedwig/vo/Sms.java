package com.gescc.hedwig.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sms {
	private String title;
	@JsonProperty("receiver_number")
	private String receiverNumber;
	@JsonProperty("application_name")
	private String applicationName;
	private String contents;
	@JsonProperty("callback_url")
	private String callbackUrl;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReceiverName() {
		return receiverNumber;
	}

	public void setReceiverName(String receiverNumber) {
		this.receiverNumber = receiverNumber;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
	
	@Override
	public String toString() {
		return "Sms [title=" + title + ", receiver_number=" + receiverNumber + ", application_name=" + applicationName + 
				", contents=" + contents + ", callbackUrl=" + callbackUrl + "]";
	}
}
