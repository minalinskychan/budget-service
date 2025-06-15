package com.gin.service;

import com.gin.request.PostingSkdsCallbackRequest;
import com.gin.response.CallbackResponse;

public interface SiskeudesService {
	public CallbackResponse callback(PostingSkdsCallbackRequest request);
}
