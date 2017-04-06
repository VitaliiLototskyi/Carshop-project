package ua.dto.form;

import org.springframework.web.multipart.MultipartFile;

import ua.entity.BodyStyle;
import ua.entity.Color;
import ua.entity.GearBox;
import ua.entity.Model;

public class CarForm {
	private int id;
	private String name;
	private String year;
	private BodyStyle bodyStyle;
	private GearBox gearBox;
	private Integer version;
	private MultipartFile file;
	private Color color;
	private Model model;
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public MultipartFile getFile() {
		return file;
	}
	
	
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public BodyStyle getBodyStyle() {
		return bodyStyle;
	}
	public void setBodyStyle(BodyStyle bodyStyle) {
		this.bodyStyle = bodyStyle;
	}
	public GearBox getGearBox() {
		return gearBox;
	}
	public void setGearBox(GearBox gearBox) {
		this.gearBox = gearBox;
	}
	
}
