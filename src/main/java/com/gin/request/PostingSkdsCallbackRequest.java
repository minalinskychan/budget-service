package com.gin.request;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostingSkdsCallbackRequest {
	@JsonProperty("response_code")
	private String response_code;
	@JsonProperty("kd_desa")
    private String kd_desa;
	@JsonProperty("count")
	private int count;
	@JsonProperty("message")
    private String message;
	@JsonProperty("data")
	private Set<DataPaymentSkdsResponse> data;
	@JsonProperty("transaction_id")
	private String transactionId;

	public PostingSkdsCallbackRequest() {
		super();
	}

	public String getResponse_code() {
		return response_code;
	}

	public void setResponse_code(String response_code) {
		this.response_code = response_code;
	}

	public String getKd_desa() {
		return kd_desa;
	}

	public void setKd_desa(String kd_desa) {
		this.kd_desa = kd_desa;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Set<DataPaymentSkdsResponse> getData() {
		return data;
	}

	public void setData(Set<DataPaymentSkdsResponse> data) {
		this.data = data;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}