package com.gin.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionRequest {
	@JsonProperty("tanggal")
	private String tanggal;
	@JsonProperty("deskripsi")
	private String deskripsi;
	@JsonProperty("total")
	private String total;
	@JsonProperty("category")
	private String category;
	@JsonProperty("name")
	private String name;

	public TransactionRequest() {
		super();
	}

	public String getTanggal() {
		return tanggal;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}