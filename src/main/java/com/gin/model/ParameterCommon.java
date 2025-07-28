package com.gin.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "common")
public class ParameterCommon implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column
	private String id;
	@Column
	private String code;
	@Column
	private String value;


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
		if (!(o.getClass().isAssignableFrom(ParameterCommon.class))) {
			return false;
		}

		final ParameterCommon cc = (ParameterCommon) o;

		return (id == cc.getId());
	}

	@Override
	public int hashCode() {
		int hashcode = id == null ? new Long(0).hashCode() : ((String) id).hashCode();
		return hashcode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


//	public String getFormattedDate() {
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy hh:mm:ss a");
//		formattedDate = sdf.format(getDate());
//		return formattedDate;
//	}
}
