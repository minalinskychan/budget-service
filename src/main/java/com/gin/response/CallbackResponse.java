package com.gin.response;

import java.util.List;

import com.gin.model.Transaksi;
import com.gin.util.Constants;

public class CallbackResponse {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -9035536140072673346L;
	private String message;
	private String reasonCode;
	private List<Transaksi> transaksi;
	

	public CallbackResponse(boolean success,List<Transaksi> transaksi) {
		this.transaksi=transaksi;
		if(success)
			setSuccessCallbackSkds();
		else
			setFailedCallbackSkds();
	}
	public CallbackResponse(boolean success) {
		if(success)
			setSuccessCallbackSkds();
		else
			setFailedCallbackSkds();
	}
	public void setSuccessCallbackSkds() {
		this.message = Constants.MESSAGE_SUCCESS;
		this.reasonCode=Constants.RC_SUCCESS;
	}
	public void setFailedCallbackSkds() {
		this.message = Constants.MESSAGE_GENERAL_ERROR;
		this.reasonCode=Constants.RC_GENERAL_ERROR;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getReasonCode() {
		return reasonCode;
	}
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	public List<Transaksi> getTransaksi() {
		return transaksi;
	}
	public void setTransaksi(List<Transaksi> transaksi) {
		this.transaksi = transaksi;
	}


}
