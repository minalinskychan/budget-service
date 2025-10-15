package com.gin.service;

import com.gin.request.TotalRequest;
import com.gin.request.TransactionRequest;
import com.gin.response.AddTransaksiResponse;
import com.gin.response.TargetKeuangan;

public interface TransactionBudgetService {
	

	public AddTransaksiResponse tambah(TransactionRequest request);
	public Double total();
	public String totalSpecificMont(TotalRequest totalRequest);
	public String totalAverage();


	public String totalSpecificMonth(String month, String year);
	public String totalSpecificYear(String year);
	public TargetKeuangan totalFinancialPlan();
	public void getAllSpend();
}
