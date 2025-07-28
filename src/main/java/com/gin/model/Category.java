package com.gin.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "kategori")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column
	private String id;
	@Column
	private String categoryName;
	@Column
	private BigDecimal categoryAllocation;


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
		if (!(o.getClass().isAssignableFrom(Category.class))) {
			return false;
		}

		final Category cc = (Category) o;

		return (id == cc.getId());
	}

	@Override
	public int hashCode() {
		int hashcode = id == null ? new Long(0).hashCode() : ((String) id).hashCode();
		return hashcode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public BigDecimal getCategoryAllocation() {
		return categoryAllocation;
	}

	public void setCategoryAllocation(BigDecimal categoryAllocation) {
		this.categoryAllocation = categoryAllocation;
	}

//	public String getFormattedDate() {
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy hh:mm:ss a");
//		formattedDate = sdf.format(getDate());
//		return formattedDate;
//	}
}
