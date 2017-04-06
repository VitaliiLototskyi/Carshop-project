package ua.service.implementation;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.dto.form.GearBoxForm;
import ua.entity.GearBox;
import ua.repository.GearBoxRepository;
import ua.service.GearBoxService;
@Service
public class GearBoxServiceImpl implements GearBoxService {
	@Autowired
	private GearBoxRepository repository;

	@Override
	@Transactional(readOnly = true)
	public GearBox findOne(int id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<GearBox> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(GearBoxForm gearBoxForm) {
		GearBox gearBox = new GearBox();
		gearBox.setId(gearBoxForm.getId());
		gearBox.setGearType(gearBoxForm.getGearType());
		gearBox.setCount(Integer.valueOf(gearBoxForm.getCount()));
		repository.save(gearBox);
	}
	@Override
	public GearBoxForm findForm(int id) {
		GearBox gearBox = repository.findOne(id);
		GearBoxForm gearBoxForm = new GearBoxForm();
		gearBoxForm.setId(gearBox.getId());
		gearBoxForm.setCount(String.valueOf(gearBox.getCount()));
		gearBoxForm.setGearType(gearBox.getGearType());
		return gearBoxForm;
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
	}

	
	
}
