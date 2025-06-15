package com.gin.service.dummy;

import org.springframework.stereotype.Service;

import com.gin.request.PostingSkdsCallbackRequest;
import com.gin.response.CallbackResponse;
import com.gin.service.SiskeudesService;

@Service("siskeudesServiceDummy")
public class SiskeudesServiceDummyImpl implements SiskeudesService {


	@Override
	public CallbackResponse callback(PostingSkdsCallbackRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
