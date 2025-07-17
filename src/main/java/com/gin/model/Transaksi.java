package com.gin.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "transaksi")
public class Transaksi implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column
	private String id;
	@Column
	private String spendName;
	@Column
	private String spendDetail;
	@Column
	private String category;
	@Column
	private Date spendDate;
	@Column
	private BigDecimal spendAmount;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// ==================================
	// OVERRIDEN METHODS
	// ==================================
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o.getClass().isAssignableFrom(Transaksi.class))) {
			return false;
		}

		final Transaksi cc = (Transaksi) o;

		return (id == cc.getId());
	}

	@Override
	public int hashCode() {
		int hashcode = id == null ? new Long(0).hashCode() : ((String) id).hashCode();
		return hashcode;
	}

	public String getSpendName() {
		return spendName;
	}

	public void setSpendName(String spendName) {
		this.spendName = spendName;
	}

	public String getSpendDetail() {
		return spendDetail;
	}

	public void setSpendDetail(String spendDetail) {
		this.spendDetail = spendDetail;
	}

	public Date getSpendDate() {
		return spendDate;
	}

	public void setSpendDate(Date spendDate) {
		this.spendDate = spendDate;
	}

	public BigDecimal getSpendAmount() {
		return spendAmount;
	}

	public void setSpendAmount(BigDecimal spendAmount) {
		this.spendAmount = spendAmount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

//	public String getFormattedDate() {
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy hh:mm:ss a");
//		formattedDate = sdf.format(getDate());
//		return formattedDate;
//	}
}
