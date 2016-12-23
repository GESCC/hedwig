package com.gescc.hedwig.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultView {

	private String code;
	private String message;
	
	@JsonProperty("code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@JsonProperty("message")
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public ResultView(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "ResultView [code=" + code + ", message=" + message + "]";
	}
	
	
	
}
