package com.gabia.api;

public class ApiResult {
	private String code = "";
	private String mesg = "";
	
	public ApiResult( String code, String mesg ) {
		
		this.code = code;
		this.mesg = mesg;
		
	}
	
	public String getCode()
	{
		return this.code;
	}
	
	public String getMesg()
	{
		return this.mesg;
	}
	
	
}
