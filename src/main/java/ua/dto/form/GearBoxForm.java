package ua.dto.form;

import ua.entity.GearType;

public class GearBoxForm {
	private int id;
	private String count;
	private GearType gearType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public GearType getGearType() {
		return gearType;
	}
	public void setGearType(GearType gearType) {
		this.gearType = gearType;
	}
}
