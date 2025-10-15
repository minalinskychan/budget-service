package com.gin.response;

import java.util.List;

import com.gin.model.Transaksi;

public class AddTransaksiResponse extends BaseResponse{
	private static final long serialVersionUID = -9035536140072673346L;
	List<Transaksi> transaksis;

	public AddTransaksiResponse(boolean success, List<Transaksi> transaksis) {
		super(success);
		this.transaksis=transaksis;
	}
	public AddTransaksiResponse(boolean success) {
		super(success);
	}
	public List<Transaksi> getTransaksis() {
		return transaksis;
	}
	public void setTransaksis(List<Transaksi> transaksis) {
		this.transaksis = transaksis;
	}


}
