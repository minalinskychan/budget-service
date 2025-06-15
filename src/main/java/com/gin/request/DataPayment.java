package com.gin.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataPayment {
	@JsonProperty("success")
	private boolean success;
	@JsonProperty("data")
    private String data;
	@JsonProperty("message")
    private String message;
	
	public DataPayment(){
		super();
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
