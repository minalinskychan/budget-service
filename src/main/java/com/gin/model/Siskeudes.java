package com.gin.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "siskeudes")
public class Siskeudes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column
	private String id;
	@Column
	private String no;
	private Date date;
	@Column (name="document_no")
	private String documentNo;
	@Column (name="document_date")
	private Date documentDate;
	@Column (name="opd_code")
	private String opdCode;
	@Column (name="opd_name")
	private String opdName;
	private String description;
	@Column (name="treasurer_name")
	private String treasurerName;
	@Column
	private BigDecimal amount;
	@Column
	private BigDecimal taxAmount;
	@Column
	private BigDecimal adminCharge;
	@Column
	private BigDecimal total;
	@Column
	private String skdsAreaCode;
	@Column(name = "account_source_no")
	private String accountSourceNo;
	@Column(name = "account_source_name")
	private String accountSourceName;
	@Column(name = "bank_source_name")
	private String bankSourceName;
	@Column
	private String currency;
	@Column(name = "response_code")
	private String responseCode;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "skds", fetch = FetchType.LAZY)
	@OrderBy("receiptNo")
	private Set<SkdsBuktiBayar> receipts = new HashSet<SkdsBuktiBayar>();

	@Column
	private int status;
	@Column(name = "status_approval")
	private int statusApproval;
	
	@Transient
	private boolean enableApproval;
	@Transient
	private boolean enableRelease;
	@Transient
	private String refNo;
	@Transient
	private String formattedDate;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAccountSourceNo() {
		return accountSourceNo;
	}

	public void setAccountSourceNo(String accountSourceNo) {
		this.accountSourceNo = accountSourceNo;
	}

	public String getAccountSourceName() {
		return accountSourceName;
	}

	public void setAccountSourceName(String accountSourceName) {
		this.accountSourceName = accountSourceName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatusApproval() {
		return statusApproval;
	}

	public void setStatusApproval(int statusApproval) {
		this.statusApproval = statusApproval;
	}

	public boolean isEnableApproval() {
		return enableApproval;
	}

	public void setEnableApproval(boolean enableApproval) {
		this.enableApproval = enableApproval;
	}

	public boolean isEnableRelease() {
		return enableRelease;
	}

	public void setEnableRelease(boolean enableRelease) {
		this.enableRelease = enableRelease;
	}

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public Date getDocumentDate() {
		return documentDate;
	}

	public void setDocumentDate(Date documentDate) {
		this.documentDate = documentDate;
	}

	public String getOpdCode() {
		return opdCode;
	}

	public void setOpdCode(String opdCode) {
		this.opdCode = opdCode;
	}

	public String getOpdName() {
		return opdName;
	}

	public void setOpdName(String opdName) {
		this.opdName = opdName;
	}

	public String getTreasurerName() {
		return treasurerName;
	}

	public void setTreasurerName(String treasurerName) {
		this.treasurerName = treasurerName;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public BigDecimal getAdminCharge() {
		return adminCharge;
	}

	public void setAdminCharge(BigDecimal adminCharge) {
		this.adminCharge = adminCharge;
	}
	
	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	public Set<SkdsBuktiBayar> getReceipts() {
		return receipts;
	}

	public void setReceipts(Set<SkdsBuktiBayar> receipts) {
		this.receipts = receipts;
	}

	public String getSkdsAreaCode() {
		return skdsAreaCode;
	}

	public void setSkdsAreaCode(String skdsAreaCode) {
		this.skdsAreaCode = skdsAreaCode;
	}

	// ==================================
	// OVERRIDEN METHODS
	// ==================================
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o.getClass().isAssignableFrom(Siskeudes.class))) {
			return false;
		}

		final Siskeudes cc = (Siskeudes) o;

		return (id == cc.getId());
	}

	@Override
	public int hashCode() {
		int hashcode = id == null ? new Long(0).hashCode() : ((String) id).hashCode();
		return hashcode;
	}

	public String getBankSourceName() {
		return bankSourceName;
	}

	public void setBankSourceName(String bankSourceName) {
		this.bankSourceName = bankSourceName;
	}

	public String getFormattedDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy hh:mm:ss a");
		formattedDate = sdf.format(getDate());
		return formattedDate;
	}
}
