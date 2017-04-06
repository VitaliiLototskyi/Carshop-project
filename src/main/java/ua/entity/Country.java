package ua.entity;
import javax.persistence.Index;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="country",indexes=@Index(columnList="_name"))
public class Country extends AbstractEntity  {
	@Column(name="_name")
	private String name;
	@OneToMany(mappedBy="country")
	private List<Producer> producers = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
