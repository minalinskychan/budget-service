package com.gin.service;

import com.gin.request.TotalRequest;
import com.gin.request.TransactionRequest;
import com.gin.response.CallbackResponse;
import com.gin.response.TargetKeuangan;

public interface TransactionBudgetService {
	

	public CallbackResponse tambah(TransactionRequest request);
	public String total();
	public String totalSpecificMont(TotalRequest totalRequest);
	public String totalAverage();


	public String totalSpecificMonth(String month, String year);
	public String totalSpecificYear(String year);
	public TargetKeuangan totalFinancialPlan();
}
