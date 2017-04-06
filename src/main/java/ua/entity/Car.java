package ua.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Index;
@Entity
@Table(name="car",indexes=@Index(columnList = "_name"))
public class Car extends AbstractEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	private Model model;
	
	@ManyToOne(fetch= FetchType.LAZY)
	private GearBox gearBox;
	@ManyToOne(fetch=FetchType.LAZY)
	private Color color;
	@Enumerated
	private BodyStyle bodyStyle;
	@Column(name="_name")
	private String name;
	@Column(name = "version", nullable = true)
	private Integer version;
	@Column(name="year")
	private int year;
	@Transient
	private MultipartFile file;
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public BodyStyle getBodyStyle() {
		return bodyStyle;
	}

	public void setBodyStyle(BodyStyle bodyStyle) {
		this.bodyStyle = bodyStyle;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	

	public GearBox getGearBox() {
		return gearBox;
	}

	public void setGearBox(GearBox gearBox) {
		this.gearBox = gearBox;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
