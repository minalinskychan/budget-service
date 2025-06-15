package com.gin.request;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataPaymentSkdsResponse {
	@JsonProperty("kd_cms")
    private String kd_cms;
	@JsonProperty("no_spp")
    private String no_spp;
	@JsonProperty("tgl_spp")
    private String tgl_spp;
	@JsonProperty("no_bukti")
    private String no_bukti;
	@JsonProperty("tgl_bukti")
    private String tgl_bukti;
	@JsonProperty("nm_pemilik")
    private String nm_pemilik;
	@JsonProperty("nm_bank_desa")
    private String nm_bank_desa;
	@JsonProperty("rek_bank_desa")
    private String rek_bank_desa;
	@JsonProperty("nm_penerima")
    private String nm_penerima;
	@JsonProperty("nm_bank_penerima")
    private String nm_bank_penerima;
	@JsonProperty("rek_bank_penerima")
    private String rek_bank_penerima;
	@JsonProperty("kd_bank_penerima")
    private String kd_bank_penerima;
	@JsonProperty("npwp_penerima")
    private String npwp_penerima;
	@JsonProperty("kd_kegiatan")
    private String kd_kegiatan;
	@JsonProperty("kode_belanja")
    private String kode_belanja;
	@JsonProperty("uraian_belanja")
    private String uraian_belanja;
	@JsonProperty("kd_sumber")
    private String kd_sumber;
	@JsonProperty("nilai_belanja")
    private String nilai_belanja;
	@JsonProperty("nilai_potongan")
    private String nilai_potongan;
	@JsonProperty("nilai_terima")
    private String nilai_terima;
	@JsonProperty("keterangan")
    private String keterangan;
	@JsonProperty("status_pembayaran")
    private int status_pembayaran;
	@JsonProperty("log_cr")
    private Date log_cr;
	@JsonProperty("daftar_potongan_mpn")
	private Set<DaftarPotonganMpn> daftar_potongan_mpn;
	@JsonProperty("daftar_potongan_daerah")
    private Set<DaftarPotonganDaerah> daftar_potongan_daerah;
	
	public DataPaymentSkdsResponse(){
		super();
	}

	public String getKd_cms() {
		return kd_cms;
	}

	public void setKd_cms(String kd_cms) {
		this.kd_cms = kd_cms;
	}

	public String getNo_spp() {
		return no_spp;
	}

	public void setNo_spp(String no_spp) {
		this.no_spp = no_spp;
	}

	public String getTgl_spp() {
		return tgl_spp;
	}

	public void setTgl_spp(String tgl_spp) {
		this.tgl_spp = tgl_spp;
	}

	public String getNo_bukti() {
		return no_bukti;
	}

	public void setNo_bukti(String no_bukti) {
		this.no_bukti = no_bukti;
	}

	public String getTgl_bukti() {
		return tgl_bukti;
	}

	public void setTgl_bukti(String tgl_bukti) {
		this.tgl_bukti = tgl_bukti;
	}

	public String getNm_pemilik() {
		return nm_pemilik;
	}

	public void setNm_pemilik(String nm_pemilik) {
		this.nm_pemilik = nm_pemilik;
	}

	public String getNm_bank_desa() {
		return nm_bank_desa;
	}

	public void setNm_bank_desa(String nm_bank_desa) {
		this.nm_bank_desa = nm_bank_desa;
	}

	public String getRek_bank_desa() {
		return rek_bank_desa;
	}

	public void setRek_bank_desa(String rek_bank_desa) {
		this.rek_bank_desa = rek_bank_desa;
	}

	public String getNm_penerima() {
		return nm_penerima;
	}

	public void setNm_penerima(String nm_penerima) {
		this.nm_penerima = nm_penerima;
	}

	public String getNm_bank_penerima() {
		return nm_bank_penerima;
	}

	public void setNm_bank_penerima(String nm_bank_penerima) {
		this.nm_bank_penerima = nm_bank_penerima;
	}

	public String getRek_bank_penerima() {
		return rek_bank_penerima;
	}

	public void setRek_bank_penerima(String rek_bank_penerima) {
		this.rek_bank_penerima = rek_bank_penerima;
	}

	public String getKd_bank_penerima() {
		return kd_bank_penerima;
	}

	public void setKd_bank_penerima(String kd_bank_penerima) {
		this.kd_bank_penerima = kd_bank_penerima;
	}

	public String getNpwp_penerima() {
		return npwp_penerima;
	}

	public void setNpwp_penerima(String npwp_penerima) {
		this.npwp_penerima = npwp_penerima;
	}

	public String getKd_kegiatan() {
		return kd_kegiatan;
	}

	public void setKd_kegiatan(String kd_kegiatan) {
		this.kd_kegiatan = kd_kegiatan;
	}

	public String getKode_belanja() {
		return kode_belanja;
	}

	public void setKode_belanja(String kode_belanja) {
		this.kode_belanja = kode_belanja;
	}

	public String getUraian_belanja() {
		return uraian_belanja;
	}

	public void setUraian_belanja(String uraian_belanja) {
		this.uraian_belanja = uraian_belanja;
	}

	public String getKd_sumber() {
		return kd_sumber;
	}

	public void setKd_sumber(String kd_sumber) {
		this.kd_sumber = kd_sumber;
	}

	public String getNilai_belanja() {
		return nilai_belanja;
	}

	public void setNilai_belanja(String nilai_belanja) {
		this.nilai_belanja = nilai_belanja;
	}

	public String getNilai_potongan() {
		return nilai_potongan;
	}

	public void setNilai_potongan(String nilai_potongan) {
		this.nilai_potongan = nilai_potongan;
	}

	public String getNilai_terima() {
		return nilai_terima;
	}

	public void setNilai_terima(String nilai_terima) {
		this.nilai_terima = nilai_terima;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	public int getStatus_pembayaran() {
		return status_pembayaran;
	}

	public void setStatus_pembayaran(int status_pembayaran) {
		this.status_pembayaran = status_pembayaran;
	}

	public Date getLog_cr() {
		return log_cr;
	}

	public void setLog_cr(Date log_cr) {
		this.log_cr = log_cr;
	}

	public Set<DaftarPotonganMpn> getDaftar_potongan_mpn() {
		return daftar_potongan_mpn;
	}

	public void setDaftar_potongan_mpn(Set<DaftarPotonganMpn> daftar_potongan_mpn) {
		this.daftar_potongan_mpn = daftar_potongan_mpn;
	}

	public Set<DaftarPotonganDaerah> getDaftar_potongan_daerah() {
		return daftar_potongan_daerah;
	}

	public void setDaftar_potongan_daerah(Set<DaftarPotonganDaerah> daftar_potongan_daerah) {
		this.daftar_potongan_daerah = daftar_potongan_daerah;
	}
}
