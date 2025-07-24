package com.gin.response;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gin.model.Transaksi;
import com.gin.repository.TransaksiRepository;
import com.gin.util.Constants;

public class DanaPensiun {
	private static final long serialVersionUID = -9035536140072673346L;
	private String Keterangan;
	private String nominal;
	private String alokasiRdpt;
	private String alokasiDeposito;
	public DanaPensiun() {
		super();
	}
	public DanaPensiun(String keterangan, String nominal, String alokasiRdpt, String alokasiDeposito) {
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
	public String getAlokasiRdpt() {
		return alokasiRdpt;
	}
	public void setAlokasiRdpt(String alokasiRdpt) {
		this.alokasiRdpt = alokasiRdpt;
	}
	public String getAlokasiDeposito() {
		return alokasiDeposito;
	}
	public void setAlokasiDeposito(String alokasiDeposito) {
		this.alokasiDeposito = alokasiDeposito;
	}
	
}
