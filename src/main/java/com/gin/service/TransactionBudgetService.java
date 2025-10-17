package com.gin.service;

import com.gin.request.TotalRequest;
import com.gin.request.TransactionRequest;
import com.gin.response.TargetKeuangan;
import com.gin.response.TransaksiResponse;

public interface TransactionBudgetService {
	

	public TransaksiResponse tambah(TransactionRequest request);
	public String total();
	public String totalSpecificMont(TotalRequest totalRequest);
	public String totalAverage();


	public TransaksiResponse getThisMonth();
	public TransaksiResponse getSpecificYear();
	public TargetKeuangan totalFinancialPlan();
	public TransaksiResponse getAllTransaction();
	public TransaksiResponse getSpecifictRequestTransaction(TotalRequest totalRequest);
}
