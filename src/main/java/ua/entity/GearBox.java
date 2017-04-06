package ua.entity;
import javax.persistence.Index;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="gear_box", indexes=@Index(columnList="count"))
public class GearBox extends AbstractEntity {
	@Column(name="count")
	private int count;
	@Enumerated
	private GearType gearType;
	@OneToMany(mappedBy="gearBox")
	private List<Car> cars = new ArrayList<>();

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public GearType getGearType() {
		return gearType;
	}

	public void setGearType(GearType gearType) {
		this.gearType = gearType;
	}

	

}
