package com.incture.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="basic_data")
public class BasicData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="equipmentId")
	private String equipmentId;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "available")
	private int available;
	
	@Column(name = "validFrom")
	@Temporal(TemporalType.DATE)
	private Date validFrom;
	
	@Column(name = "validTo")
	@Temporal(TemporalType.DATE)
	private Date validTo;

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	
	public BasicData()
	{
		super();
	}

	public BasicData(String equipmentId, String category, String description, int status, int available, Date validFrom,
			Date validTo) {
		super();
		this.equipmentId = equipmentId;
		this.category = category;
		this.description = description;
		this.status = status;
		this.available = available;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}

	@Override
	public String toString() {
		return "BasicData [equipmentId=" + equipmentId + ", category=" + category + ", description=" + description
				+ ", status=" + status + ", available=" + available + ", validFrom=" + validFrom + ", validTo="
				+ validTo + "]";
	}
	
			
	
	
	
}
