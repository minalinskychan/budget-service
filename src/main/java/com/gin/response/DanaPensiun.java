package com.gin.response;

import java.util.List;

public class DanaPensiun {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -9035536140072673346L;
	private String Keterangan;
	private String nominal;
	private String alokasiRdpt;
	private List<String> alokasiDeposito;
	public DanaPensiun() {
		super();
	}
	public DanaPensiun(String keterangan, String nominal, String alokasiRdpt, List<String> alokasiDeposito) {
		super();
		Keterangan = keterangan;
		this.nominal = nominal;
		this.alokasiRdpt = alokasiRdpt;
		this.alokasiDeposito = alokasiDeposito;
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
	public List<String> getAlokasiDeposito() {
		return alokasiDeposito;
	}
	public void setAlokasiDeposito(List<String> alokasiDeposito) {
		this.alokasiDeposito = alokasiDeposito;
	}
	public String getAlokasiRdpt() {
		return alokasiRdpt;
	}
	public void setAlokasiRdpt(String alokasiRdpt) {
		this.alokasiRdpt = alokasiRdpt;
	}
}
