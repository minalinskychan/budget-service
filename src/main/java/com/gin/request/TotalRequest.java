package com.gin.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TotalRequest {
	@JsonProperty("day")
	private String tanggal;
	@JsonProperty("day_end")
	private String tanggalAkhir;
	@JsonProperty("month")
	private String bulan;
	@JsonProperty("month_end")
	private String bulanAkhir;
	@JsonProperty("year")
	private String tahun;
	@JsonProperty("year_end")
	private String tahunAkhir;

	public TotalRequest() {
		super();
	}

	public String getTanggal() {
		return tanggal;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}

	public String getTanggalAkhir() {
		return tanggalAkhir;
	}

	public void setTanggalAkhir(String tanggalAkhir) {
		this.tanggalAkhir = tanggalAkhir;
	}

	public String getBulan() {
		return bulan;
	}

	public void setBulan(String bulan) {
		this.bulan = bulan;
	}

	public String getBulanAkhir() {
		return bulanAkhir;
	}

	public void setBulanAkhir(String bulanAkhir) {
		this.bulanAkhir = bulanAkhir;
	}

	public String getTahun() {
		return tahun;
	}

	public void setTahun(String tahun) {
		this.tahun = tahun;
	}

	public String getTahunAkhir() {
		return tahunAkhir;
	}

	public void setTahunAkhir(String tahunAkhir) {
		this.tahunAkhir = tahunAkhir;
	}

}