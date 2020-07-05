package com.incture.dto;

public class BasicDTO {
	
	private String equipmentId;
	private int status;
	
	
	public String getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public BasicDTO(String equipmentId, int status) {
		super();
		this.equipmentId = equipmentId;
		this.status = status;
	}
	@Override
	public String toString() {
		return "BasicDTO [equipmentId=" + equipmentId + ", status=" + status + "]";
	}
	
	

}
