package com.gin.response;

import java.util.List;

import com.gin.model.Transaksi;

public class TransaksiResponse extends BaseResponse{
	private static final long serialVersionUID = -9035536140072673346L;
	List<Transaksi> transaksis;
	String total;

	public TransaksiResponse(boolean success, List<Transaksi> transaksis) {
		super(success);
		this.transaksis=transaksis;
	}
	public TransaksiResponse(boolean success, List<Transaksi> transaksis, String total) {
		super(success);
		this.transaksis=transaksis;
		this.total=total;
	}
	public TransaksiResponse(boolean success) {
		super(success);
	}
	public List<Transaksi> getTransaksis() {
		return transaksis;
	}
	public void setTransaksis(List<Transaksi> transaksis) {
		this.transaksis = transaksis;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}


}
