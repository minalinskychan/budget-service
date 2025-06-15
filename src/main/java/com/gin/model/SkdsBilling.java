package com.gin.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.gin.util.GeneratorUtil;

@Entity
@Table(name = "skds_billing")
public class SkdsBilling implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column
	private String id;
	@Column(name = "billing_id")
	private String billingId;
	@Column(name = "name")
	private String name;
	@Column(name = "code")
	private String code;
	@Column(name = "amount")
	private BigDecimal amount;
	@Column(name = "mpn_inquiry_msg")
	private String mpnInquiryMessage;
	@Column(name = "mpn_inquiry_rc")
	private String mpnInquiryRc;
	@Column(name = "mpn_execute_rc")
	private String mpnExecuteRc;
	@Column(name = "description")
	private String description;
	@Column(name = "depositor_npwp")
	private String depositorNpwp;
	@Column(name = "received_npwp")
	private String receivedNpwp;
	@Column(name = "deposit_type")
	private String depositType;
	@Column(name = "map_code")
	private String mapCode;
	@Column(name = "tax_period")
	private int taxPeriod;
	@Column(name = "tax_year")
	private int taxYear;
	@Column(name = "nop")
	private String nop;
	@Column(name = "payment_status")
	private int paymentStatus;
	@Column(name = "trace_number")
	private String traceNumber;
	@Column(name = "area_code")
	private String areaCode;
	@Column(name = "area_name")
	private String areaName;
	@Column(name = "tax_code")
	private String taxCode;
	@Column(name = "tax_subject_name")
	private String taxSubjectName;
	@Column(name = "period")
	private String period;
	@Column(name = "installment")
	private String installment;
	@Column(name = "tax_object_name")
	private String taxObjectName;
	@Column(name = "tax_object_address")
	private String taxObjectAddress;
	@Column(name = "due_date")
	private String dueDate;
	@Column(name = "collective_amount")
	private String collectiveAmount;
	@Column(name = "penalty_amount")
	private String penaltyAmount;
	@Column(name = "admin_charge")
	private String adminCharge;
	@Column(name = "total_amount")
	private String totalAmount;
	@Column(name = "ntb")
	private String ntb;
	@Column(name = "ntpn")
	private String ntpn;
	@Column(name = "tgl_buku_ntpn")
	private String tglBukuNtpn;
	@Column(name = "success")
	private boolean success;
//	@ManyToOne(cascade = CascadeType.REFRESH)
//	@JoinColumn(name = "receipt_id", nullable = true)
	@Column(name = "receipt_id")
	private String receipt;
	@Transient
	private String forrmatedDueDate;
	@Transient
	private long penaltyAmountLong;
	@Transient
	private long adminChargeLong;
	@Transient
	private long totalAmountLong;
	@Transient
	private long collectiveAmountLong;
	@Transient
	private String formattedAdminChargeLong;
	@Transient
	private String formattedTotalAmountLong;
	@Transient
	private String formattedCollectiveAmountLong;
	@Transient
	private String formattedPenaltyAmountLong;
	
//	MPN
	@Column(name = "transaction_time")
	private String transactionTime;
	@Column(name = "ntpn_date")
	private String ntpnDate;
	@Column(name = "branch_code")
	private String branchCode;
	@Column(name = "stan")
	private String stan;
	@Column(name = "npwp")
	private String npwp;
	@Column(name = "tax_npwp_name")
	private String taxNpwpName;
	@Column(name = "address")
	private String address;
	@Column(name = "mpn_total_amount")
	private String mpnTotalAmount;
	@Transient
	private Long mpnTotalAmountLong;
	@Transient
	private String spelledAmount;
	@Transient
	private boolean pendingPajakMpn;
	
	@Transient
	protected NumberFormat formatter;
	

	public boolean isPendingPajakMpn() {
		pendingPajakMpn = GeneratorUtil.pajakMpn(this.code)&&GeneratorUtil.nullSafeNumber(this.mpnExecuteRc).equals("08");
		return pendingPajakMpn;
	}
	
	public String format(long nominal) {
		if (formatter == null) {
			formatter = new DecimalFormat();
			formatter.setGroupingUsed(true);
			formatter.setMinimumFractionDigits(2);
			formatter.setMaximumFractionDigits(2);
		}
		return formatter.format(nominal);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBillingId() {
		return billingId;
	}

	public void setBillingId(String billingId) {
		this.billingId = billingId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getMpnInquiryMessage() {
		return mpnInquiryMessage;
	}

	public void setMpnInquiryMessage(String mpnInquiryMessage) {
		this.mpnInquiryMessage = mpnInquiryMessage;
	}

	public String getMpnInquiryRc() {
		return mpnInquiryRc;
	}

	public void setMpnInquiryRc(String mpnInquiryRc) {
		this.mpnInquiryRc = mpnInquiryRc;
	}

	public String getMpnExecuteRc() {
		return mpnExecuteRc;
	}

	public void setMpnExecuteRc(String mpnExecuteRc) {
		this.mpnExecuteRc = mpnExecuteRc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

//	public SkdsBuktiBayar getReceipt() {
//		return receipt;
//	}
//
//	public void setReceipt(SkdsBuktiBayar receipt) {
//		this.receipt = receipt;
//	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDepositorNpwp() {
		return depositorNpwp;
	}

	public void setDepositorNpwp(String depositorNpwp) {
		this.depositorNpwp = depositorNpwp;
	}

	public String getReceivedNpwp() {
		return receivedNpwp;
	}

	public void setReceivedNpwp(String receivedNpwp) {
		this.receivedNpwp = receivedNpwp;
	}

	public String getDepositType() {
		return depositType;
	}

	public void setDepositType(String depositType) {
		this.depositType = depositType;
	}

	public String getMapCode() {
		return mapCode;
	}

	public void setMapCode(String mapCode) {
		this.mapCode = mapCode;
	}

	public int getTaxPeriod() {
		return taxPeriod;
	}

	public void setTaxPeriod(int taxPeriod) {
		this.taxPeriod = taxPeriod;
	}

	public int getTaxYear() {
		return taxYear;
	}

	public void setTaxYear(int taxYear) {
		this.taxYear = taxYear;
	}

	public String getNop() {
		return nop;
	}

	public void setNop(String nop) {
		this.nop = nop;
	}

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTraceNumber() {
		return traceNumber;
	}

	public void setTraceNumber(String traceNumber) {
		this.traceNumber = traceNumber;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getTaxSubjectName() {
		return taxSubjectName;
	}

	public void setTaxSubjectName(String taxSubjectName) {
		this.taxSubjectName = taxSubjectName;
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

	public String getTaxObjectName() {
		return taxObjectName;
	}

	public void setTaxObjectName(String taxObjectName) {
		this.taxObjectName = taxObjectName;
	}

	public String getTaxObjectAddress() {
		return taxObjectAddress;
	}

	public void setTaxObjectAddress(String taxObjectAddress) {
		this.taxObjectAddress = taxObjectAddress;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
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

	public String getTglBukuNtpn() {
		return tglBukuNtpn;
	}

	public void setTglBukuNtpn(String tglBukuNtpn) {
		this.tglBukuNtpn = tglBukuNtpn;
	}
	
	public String getFormattedDueDate() {
		try {
			
			SimpleDateFormat DATE_BILLER = new SimpleDateFormat("yyyymmdd");
			DATE_BILLER.setLenient(false);
			Date formatedDate = DATE_BILLER.parse(dueDate);
			SimpleDateFormat DATE_BSB = new SimpleDateFormat("dd/mm/yyyy");
			forrmatedDueDate = DATE_BSB.format(formatedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return forrmatedDueDate;
	}

	public long getPenaltyAmountLong() {
		penaltyAmountLong =  Long.parseLong(GeneratorUtil.nullSafeNumber( penaltyAmount));
		return penaltyAmountLong;
	}

	public long getAdminChargeLong() {
		adminChargeLong= Long.parseLong(GeneratorUtil.nullSafeNumber(adminCharge));
		return adminChargeLong;
	}

	public long getTotalAmountLong() {
		totalAmountLong= Long.parseLong(GeneratorUtil.nullSafeNumber(totalAmount));
		return totalAmountLong;
	}

	public long getCollectiveAmountLong() {
		collectiveAmountLong= Long.parseLong(GeneratorUtil.nullSafeNumber(collectiveAmount));
		return collectiveAmountLong;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getNtpnDate() {
		return ntpnDate;
	}

	public void setNtpnDate(String ntpnDate) {
		this.ntpnDate = ntpnDate;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getStan() {
		return stan;
	}

	public void setStan(String stan) {
		this.stan = stan;
	}

	public String getNpwp() {
		return npwp;
	}

	public void setNpwp(String npwp) {
		this.npwp = npwp;
	}

	public String getTaxNpwpName() {
		return taxNpwpName;
	}

	public void setTaxNpwpName(String taxNpwpName) {
		this.taxNpwpName = taxNpwpName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMpnTotalAmount() {
		return mpnTotalAmount;
	}

	public void setMpnTotalAmount(String mpnTotalAmount) {
		this.mpnTotalAmount = mpnTotalAmount;
	}

	public Long getMpnTotalAmountLong() {
		double value = Double.parseDouble(mpnTotalAmount);
		mpnTotalAmountLong = (long)value;
		return mpnTotalAmountLong;
	}
	public String getSpelledAmount() {
		spelledAmount = GeneratorUtil.angkaToTerbilang(mpnTotalAmountLong).toUpperCase().toUpperCase()+" RUPIAH";
		return spelledAmount;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getFormattedAdminChargeLong() {
		formattedAdminChargeLong = format(adminChargeLong);
		return formattedAdminChargeLong;
	}

	public String getFormattedTotalAmountLong() {
		formattedTotalAmountLong = format(totalAmountLong);
		return formattedTotalAmountLong;
	}

	public String getFormattedCollectiveAmountLong() {
		formattedCollectiveAmountLong = format(collectiveAmountLong);
		return formattedCollectiveAmountLong;
	}

	public String getFormattedPenaltyAmountLong() {
		return formattedPenaltyAmountLong;
	}

}
