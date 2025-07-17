package com.gin.request;

import java.util.Set;

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

	public TransactionRequest() {
		super();
	}
}