package ua.dto.form;

import ua.entity.EngineType;

public class EngineForm {
	private int id;
	private String sweptVolume;
	private EngineType engineType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSweptVolume() {
		return sweptVolume;
	}
	public void setSweptVolume(String sweptVolume) {
		this.sweptVolume = sweptVolume;
	}
	public EngineType getEngineType() {
		return engineType;
	}
	public void setEngineType(EngineType engineType) {
		this.engineType = engineType;
	}
}
