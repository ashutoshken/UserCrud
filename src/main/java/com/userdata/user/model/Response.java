package com.userdata.user.model;

import java.util.List;

public class Response {
	private Integer responseCode;
	private String responseMessage;
	private List<User> responseOfUserList;
	
	public Response() {
		
	}
	
	public Response(Integer responseCode, String responseMessage, List<User> responseOfUserList) {
		super();
		this.setResponseCode(responseCode);
		this.setResponseMessage(responseMessage);
		this.setResponseOfUserList(responseOfUserList);
	}

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public List<User> getResponseOfUserList() {
		return responseOfUserList;
	}

	public void setResponseOfUserList(List<User> responseOfUserList) {
		this.responseOfUserList = responseOfUserList;
	}
	

	
}
