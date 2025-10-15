package com.gin.response;

public class TargetKeuangan extends BaseResponse{
	private static final long serialVersionUID = -9035536140072673346L;
	private DanaPensiun danaPensiun;
	private DanaDarurat danaDarurat;
	

	public TargetKeuangan(boolean success,DanaPensiun danaPensiun, DanaDarurat danaDarurat) {
		super(success);
		this.danaPensiun=danaPensiun;
		this.danaDarurat=danaDarurat;
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


}
