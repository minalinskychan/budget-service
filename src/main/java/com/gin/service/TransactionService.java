package com.gin.service;

import com.gin.request.PostingSkdsCallbackRequest;
import com.gin.response.CallbackResponse;

public interface TransactionService {
	public CallbackResponse callback(PostingSkdsCallbackRequest request);
}
