package ua.entity;
import javax.persistence.Index;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "engine", indexes=@Index(columnList="sweptVolume"))
public class Engine extends AbstractEntity {
	@Column(name = "sweptVolume")
	private BigDecimal sweptVolume;
	@Enumerated
	private EngineType engineType;
	@OneToMany(mappedBy = "engine")
	private List<Model> models = new ArrayList<>();

	public BigDecimal getSweptVolume() {
		return sweptVolume;
	}

	public void setSweptVolume(BigDecimal sweptVolume) {
		this.sweptVolume = sweptVolume;
	}

	public EngineType getEngineType() {
		return engineType;
	}

	public void setEngineType(EngineType engineType) {
		this.engineType = engineType;
	}

	

}
