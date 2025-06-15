package com.gin.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * 
 * @author omega.purnomo
 *
 */
@Entity
@Table(name = "skds_bukti_bayar")
public class SkdsBuktiBayar implements Serializable{
	private static final long serialVersionUID = 7832172477052401258L;
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column
	private String id;
	@Column (name="receipt_no")
	private String receiptNo;
	@Column (name="receipt_date")
	private Date receiptDate;
	@Column (name="npwp_dest")
	private String npwpDest;
	@Column (name="unique_code")
	private String uniqueCode;
	@Column (name="description")
	private String description;
	@Column (name="bank_code")
	private String bankCode;
	@Column(name = "account_dest_no")
	private String accountDestNo;
	@Column(name = "account_dest_name")
	private String accountDestName;
	@Column(name = "activity_code")
	private String activityCode;
	@Column(name = "expense_code")
	private String expenseCode;
	@Column(name = "expense_description")
	private String expenseDescription;
	@Column(name = "source_code")
	private String sourceCode;
	@Column(name = "payment_status")
	private int paymentStatus;
	@Column(name = "log_cr")
	private Date logCr;
	@Column(name = "bank_dest_name")
	private String bankDestName;
	@Column
	private BigDecimal amount;
	@Column
	private BigDecimal taxAmount;
	@Column
	private BigDecimal receivedAmount;
	@Column
	private BigDecimal adminCharge;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "receipt", fetch = FetchType.LAZY)
	private Set<SkdsBilling> billings = new HashSet<SkdsBilling>();
//	@ManyToOne(cascade = CascadeType.REFRESH)
//	@JoinColumn(name = "skds_id", nullable = true)
	@Column(name = "skds_id")
	private String skds;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountDestNo() {
		return accountDestNo;
	}

	public void setAccountDestNo(String accountDestNo) {
		this.accountDestNo = accountDestNo;
	}

	public String getAccountDestName() {
		return accountDestName;
	}

	public void setAccountDestName(String accountDestName) {
		this.accountDestName = accountDestName;
	}
	
	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getUniqueCode() {
		return uniqueCode;
	}

	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}
	
	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	public Set<SkdsBilling> getBillings() {
		return billings;
	}

	public void setBillings(Set<SkdsBilling> billings) {
		this.billings = billings;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public BigDecimal getAdminCharge() {
		return adminCharge;
	}

	public void setAdminCharge(BigDecimal adminCharge) {
		this.adminCharge = adminCharge;
	}

//	public Siskeudes getSkds() {
//		return skds;
//	}
//
//	public void setSkds(Siskeudes skds) {
//		this.skds = skds;
//	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getReceivedAmount() {
		return receivedAmount;
	}

	public void setReceivedAmount(BigDecimal receivedAmount) {
		this.receivedAmount = receivedAmount;
	}

	public Date getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	public String getNpwpDest() {
		return npwpDest;
	}

	public void setNpwpDest(String npwpDest) {
		this.npwpDest = npwpDest;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getExpenseCode() {
		return expenseCode;
	}

	public void setExpenseCode(String expenseCode) {
		this.expenseCode = expenseCode;
	}

	public String getExpenseDescription() {
		return expenseDescription;
	}

	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Date getLogCr() {
		return logCr;
	}

	public void setLogCr(Date logCr) {
		this.logCr = logCr;
	}

	public String getBankDestName() {
		return bankDestName;
	}

	public void setBankDestName(String bankDestName) {
		this.bankDestName = bankDestName;
	}

	public String getSkds() {
		return skds;
	}

	public void setSkds(String skds) {
		this.skds = skds;
	}
	
}
