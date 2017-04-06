package ua.entity;
import javax.persistence.Index;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="model", indexes=@Index(columnList="_name"))
public class Model extends AbstractEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	private Producer producer;
	@Column(name="price")
	private BigDecimal price;
	@Column(name="_name")
	private String name;
	@ManyToOne(fetch= FetchType.LAZY)
	private Engine engine;
	
	@OneToMany(mappedBy="model")
	private List<Car> cars = new ArrayList<>();

	public Producer getProducer() {
		return producer;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	

}
