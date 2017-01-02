package com.gescc.hedwig.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author geine
 *
 */
public class Message {

	@JsonProperty("send_application_name")
	private String sendApplicationName;
	private String title;
	private String contents;
	@JsonProperty("receiver_number")
	private String receiverNumber;
	@JsonProperty("send_date")
	private Date sendDate ;
	private String result;
	
	public String getSendApplicationName() {
		return sendApplicationName;
	}
	public void setSendApplicationName(String sendApplicationName) {
		this.sendApplicationName = sendApplicationName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getReceiverNumber() {
		return receiverNumber;
	}
	public void setReceiverNumber(String receiverNumber) {
		this.receiverNumber = receiverNumber;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "Message [sendApplicationName=" + sendApplicationName + ", title=" + title + ", contents=" + contents
				+ ", receiverNumber=" + receiverNumber + ", sendDate=" + sendDate + ", result=" + result + "]";
	}
	
}
