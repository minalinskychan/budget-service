package com.gin.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DaftarPotonganMpn {
	@JsonProperty("kd_billing_potongan")
	private String kd_billing_potongan;
	@JsonProperty("kd_potongan")
    private String kd_potongan;
	@JsonProperty("uraian_potongan")
    private String uraian_potongan;
	@JsonProperty("npwp_setor")
    private String npwp_setor;
	@JsonProperty("npwp_penerima")
    private String npwp_penerima;
	@JsonProperty("jenis_setoran")
    private String jenis_setoran;
	@JsonProperty("kd_map")
    private String kd_map;
	@JsonProperty("masa_pajak")
    private int masa_pajak;
	@JsonProperty("tahun_pajak")
    private int tahun_pajak;
	@JsonProperty("nop")
    private String nop;
	@JsonProperty("nilai_potongan")
    private String nilai_potongan;
	@JsonProperty("status_pembayaran")
    private int status_pembayaran;
	@JsonProperty("waktu_transaksi")
    private String waktu_transaksi;
	@JsonProperty("no_ref_bank")
    private String no_ref_bank;
	@JsonProperty("keterangan_status")
    private String keterangan_status;
	@JsonProperty("ntb")
    private String ntb;
	@JsonProperty("ntpn")
    private String ntpn;
	@JsonProperty("tgl_buku_ntpn")
    private String tgl_buku_ntpn;
	@JsonProperty("data_payment")
    private DataPayment data_payment;
    
    public DaftarPotonganMpn(){
    	super();
    }

	public String getKd_billing_potongan() {
		return kd_billing_potongan;
	}

	public void setKd_billing_potongan(String kd_billing_potongan) {
		this.kd_billing_potongan = kd_billing_potongan;
	}

	public String getKd_potongan() {
		return kd_potongan;
	}

	public void setKd_potongan(String kd_potongan) {
		this.kd_potongan = kd_potongan;
	}

	public String getUraian_potongan() {
		return uraian_potongan;
	}

	public void setUraian_potongan(String uraian_potongan) {
		this.uraian_potongan = uraian_potongan;
	}

	public String getNpwp_setor() {
		return npwp_setor;
	}

	public void setNpwp_setor(String npwp_setor) {
		this.npwp_setor = npwp_setor;
	}

	public String getNpwp_penerima() {
		return npwp_penerima;
	}

	public void setNpwp_penerima(String npwp_penerima) {
		this.npwp_penerima = npwp_penerima;
	}

	public String getJenis_setoran() {
		return jenis_setoran;
	}

	public void setJenis_setoran(String jenis_setoran) {
		this.jenis_setoran = jenis_setoran;
	}

	public String getKd_map() {
		return kd_map;
	}

	public void setKd_map(String kd_map) {
		this.kd_map = kd_map;
	}

	public int getMasa_pajak() {
		return masa_pajak;
	}

	public void setMasa_pajak(int masa_pajak) {
		this.masa_pajak = masa_pajak;
	}

	public int getTahun_pajak() {
		return tahun_pajak;
	}

	public void setTahun_pajak(int tahun_pajak) {
		this.tahun_pajak = tahun_pajak;
	}

	public String getNop() {
		return nop;
	}

	public void setNop(String nop) {
		this.nop = nop;
	}

	public String getNilai_potongan() {
		return nilai_potongan;
	}

	public void setNilai_potongan(String nilai_potongan) {
		this.nilai_potongan = nilai_potongan;
	}

	public int getStatus_pembayaran() {
		return status_pembayaran;
	}

	public void setStatus_pembayaran(int status_pembayaran) {
		this.status_pembayaran = status_pembayaran;
	}

	public String getWaktu_transaksi() {
		return waktu_transaksi;
	}

	public void setWaktu_transaksi(String waktu_transaksi) {
		this.waktu_transaksi = waktu_transaksi;
	}

	public String getNo_ref_bank() {
		return no_ref_bank;
	}

	public void setNo_ref_bank(String no_ref_bank) {
		this.no_ref_bank = no_ref_bank;
	}

	public String getKeterangan_status() {
		return keterangan_status;
	}

	public void setKeterangan_status(String keterangan_status) {
		this.keterangan_status = keterangan_status;
	}

	public String getNtb() {
		return ntb;
	}

	public void setNtb(String ntb) {
		this.ntb = ntb;
	}

	public String getNtpn() {
		return ntpn;
	}

	public void setNtpn(String ntpn) {
		this.ntpn = ntpn;
	}

	public String getTgl_buku_ntpn() {
		return tgl_buku_ntpn;
	}

	public void setTgl_buku_ntpn(String tgl_buku_ntpn) {
		this.tgl_buku_ntpn = tgl_buku_ntpn;
	}

	public DataPayment getData_payment() {
		return data_payment;
	}

	public void setData_payment(DataPayment data_payment) {
		this.data_payment = data_payment;
	}
    
}
