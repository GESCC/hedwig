package com.gescc.hedwig.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author heedong111
 *
 */
public class App{
	
	@JsonProperty("application_name")
	private String appName;
	@JsonProperty("ip_address")
	private String ip;
	@JsonProperty("dns_address")
	private String dns;
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getDns() {
		return dns;
	}
	public void setDns(String dns) {
		this.dns = dns;
	}
	@Override
	public String toString() {
		return "App [appName=" + appName + ", ip=" + ip + ", dns=" + dns + "]";
	}
}