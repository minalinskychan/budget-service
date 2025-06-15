package com.gin.response;

import java.io.Serializable;

import com.gin.util.Constants;

public class BaseResponse implements Serializable {
	private static final long serialVersionUID = -7964015684286207288L;
	private String status;
	private String message;
	private String reasonCode;
	private String refNo;

	public BaseResponse() {
		super();
		this.status = Constants.STATUS_ACTC;
		this.message = Constants.MESSAGE_SUCCESS;
	}
	
	public BaseResponse(String refNo) {
		super();
		this.status = Constants.STATUS_ACTC;
		this.message = Constants.MESSAGE_SUCCESS;
		this.refNo = refNo;
	}

	public BaseResponse(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public void setGeneralError() {
		this.status = Constants.STATUS_RJCT;
		this.message = Constants.MESSAGE_GENERAL_ERROR;
		this.reasonCode = Constants.RC_GENERAL_ERROR;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

}
