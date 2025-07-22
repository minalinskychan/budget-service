package com.gin.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TotalRequest {
	@JsonProperty("start_date")
	private String tanggal;
	@JsonProperty("end_date")
	private String tanggalAkhir;

	public TotalRequest() {
		super();
	}

	public String getTanggal() {
		return tanggal;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}

	public String getTanggalAkhir() {
		return tanggalAkhir;
	}

	public void setTanggalAkhir(String tanggalAkhir) {
		this.tanggalAkhir = tanggalAkhir;
	}


}