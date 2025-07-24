package com.gin.response;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gin.model.Transaksi;
import com.gin.repository.TransaksiRepository;
import com.gin.util.Constants;

public class TargetKeuangan {
	private static final long serialVersionUID = -9035536140072673346L;
	private String message;
	private String reasonCode;
	private DanaPensiun danaPensiun;
	private DanaDarurat danaDarurat;
	

	public TargetKeuangan(boolean success,DanaPensiun danaPensiun, DanaDarurat danaDarurat) {
		this.danaPensiun=danaPensiun;
		this.danaDarurat=danaDarurat;
		if(success)
			setSuccessCallbackSkds();
		else
			setFailedCallbackSkds();
	}
	public TargetKeuangan(boolean success) {
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
	public DanaPensiun getDanaPensiun() {
		return danaPensiun;
	}
	public void setDanaPensiun(DanaPensiun danaPensiun) {
		this.danaPensiun = danaPensiun;
	}
	public DanaDarurat getDanaDarurat() {
		return danaDarurat;
	}
	public void setDanaDarurat(DanaDarurat danaDarurat) {
		this.danaDarurat = danaDarurat;
	}


}
