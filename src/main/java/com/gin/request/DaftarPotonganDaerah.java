package com.gin.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DaftarPotonganDaerah {
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
	@JsonProperty("trace_number")
	private String trace_number;
	@JsonProperty("area_code")
    private String area_code;
	@JsonProperty("area_name")
    private String area_name;
	@JsonProperty("tax_code")
    private String tax_code;
	@JsonProperty("tax_subject_name")
    private String tax_subject_name;
	@JsonProperty("period")
    private String period;
	@JsonProperty("installment")
    private String installment;
	@JsonProperty("tax_object_name")
    private String tax_object_name;
	@JsonProperty("tax_object_address")
    private String tax_object_address;
	@JsonProperty("due_date")
    private String due_date;
	@JsonProperty("collectiveAmount")
    private String collectiveAmount;
	@JsonProperty("penaltyAmount")
    private String penaltyAmount;
	@JsonProperty("adminCharge")
    private String adminCharge;
	@JsonProperty("totalAmount")
    private String totalAmount;
	@JsonProperty("data_payment")
    private DataPayment data_payment;
	
	public DaftarPotonganDaerah(){
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

	public String getTrace_number() {
		return trace_number;
	}

	public void setTrace_number(String trace_number) {
		this.trace_number = trace_number;
	}

	public String getArea_code() {
		return area_code;
	}

	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	public String getTax_code() {
		return tax_code;
	}

	public void setTax_code(String tax_code) {
		this.tax_code = tax_code;
	}

	public String getTax_subject_name() {
		return tax_subject_name;
	}

	public void setTax_subject_name(String tax_subject_name) {
		this.tax_subject_name = tax_subject_name;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getInstallment() {
		return installment;
	}

	public void setInstallment(String installment) {
		this.installment = installment;
	}

	public String getTax_object_name() {
		return tax_object_name;
	}

	public void setTax_object_name(String tax_object_name) {
		this.tax_object_name = tax_object_name;
	}

	public String getTax_object_address() {
		return tax_object_address;
	}

	public void setTax_object_address(String tax_object_address) {
		this.tax_object_address = tax_object_address;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public String getCollectiveAmount() {
		return collectiveAmount;
	}

	public void setCollectiveAmount(String collectiveAmount) {
		this.collectiveAmount = collectiveAmount;
	}

	public String getPenaltyAmount() {
		return penaltyAmount;
	}

	public void setPenaltyAmount(String penaltyAmount) {
		this.penaltyAmount = penaltyAmount;
	}

	public String getAdminCharge() {
		return adminCharge;
	}

	public void setAdminCharge(String adminCharge) {
		this.adminCharge = adminCharge;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public DataPayment getData_payment() {
		return data_payment;
	}

	public void setData_payment(DataPayment data_payment) {
		this.data_payment = data_payment;
	}
	
}
