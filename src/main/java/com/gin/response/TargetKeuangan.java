package com.gin.response;

public class TargetKeuangan extends BaseResponse{
	private static final long serialVersionUID = -9035536140072673346L;
	private DanaPensiun danaPensiun;
	private DanaDarurat danaDarurat;
	private String pengeluaranTahunan;
	private String rataPengeluaranTahunan;
	

	public TargetKeuangan(boolean success,DanaPensiun danaPensiun, DanaDarurat danaDarurat
			,String pengeluaranTahunan,String rataPengeluaranTahunan) {
		super(success);
		this.danaPensiun=danaPensiun;
		this.danaDarurat=danaDarurat;
		this.pengeluaranTahunan=pengeluaranTahunan;
		this.rataPengeluaranTahunan=rataPengeluaranTahunan;
	}
	public TargetKeuangan(boolean success) {
		super(success);
	}
	public DanaPensiun getDanaPensiun() {
		return danaPensiun;
	}
	public void setDanaPensiun(DanaPensiun danaPensiun) {
		this.danaPensiun = danaPensiun;
	}
	public DanaDarurat getDanaDarurat() {
		return danaDarurat;
	}
	public void setDanaDarurat(DanaDarurat danaDarurat) {
		this.danaDarurat = danaDarurat;
	}
	public String getPengeluaranTahunan() {
		return pengeluaranTahunan;
	}
	public void setPengeluaranTahunan(String pengeluaranTahunan) {
		this.pengeluaranTahunan = pengeluaranTahunan;
	}
	public String getRataPengeluaranTahunan() {
		return rataPengeluaranTahunan;
	}
	public void setRataPengeluaranTahunan(String rataPengeluaranTahunan) {
		this.rataPengeluaranTahunan = rataPengeluaranTahunan;
	}


}
