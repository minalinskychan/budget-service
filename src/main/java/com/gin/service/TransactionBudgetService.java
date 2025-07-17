package com.gin.service;

import com.gin.request.PostingSkdsCallbackRequest;
import com.gin.request.TransactionRequest;
import com.gin.response.CallbackResponse;

public interface TransactionBudgetService {
	public CallbackResponse callback(PostingSkdsCallbackRequest request);
	

	public CallbackResponse tambah(TransactionRequest request);
}
