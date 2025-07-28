package com.gin.response;

public class DanaDarurat {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -9035536140072673346L;
	private String Keterangan;
	private String nominal;
	private String alokasiRdpt;
	private String alokasiRdpuInstan;
	private String alokasiDeposito;

	public DanaDarurat(String keterangan, String nominal, String alokasiRdpt, String alokasiRdpuInstan,
			String alokasiDeposito) {
		super();
		Keterangan = keterangan;
		this.nominal = nominal;
		this.alokasiRdpt = alokasiRdpt;
		this.alokasiRdpuInstan = alokasiRdpuInstan;
		this.alokasiDeposito = alokasiDeposito;
	}
	public DanaDarurat(
			) {
		super();
	}
	
	public String getKeterangan() {
		return Keterangan;
	}
	

	public void setKeterangan(String keterangan) {
		Keterangan = keterangan;
	}
	public String getNominal() {
		return nominal;
	}
	public void setNominal(String nominal) {
		this.nominal = nominal;
	}
	public String getAlokasiRdpt() {
		return alokasiRdpt;
	}
	public void setAlokasiRdpt(String alokasiRdpt) {
		this.alokasiRdpt = alokasiRdpt;
	}
	public String getAlokasiRdpuInstan() {
		return alokasiRdpuInstan;
	}
	public void setAlokasiRdpuInstan(String alokasiRdpuInstan) {
		this.alokasiRdpuInstan = alokasiRdpuInstan;
	}
	public String getAlokasiDeposito() {
		return alokasiDeposito;
	}
	public void setAlokasiDeposito(String alokasiDeposito) {
		this.alokasiDeposito = alokasiDeposito;
	}
	



}
