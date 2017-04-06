package ua.service;

import java.util.List;

import ua.dto.form.GearBoxForm;
import ua.entity.GearBox;


public interface GearBoxService {
	GearBox findOne(int id);

	List<GearBox> findAll();
	GearBoxForm findForm(int id);
	void save(GearBoxForm gearBox);// same as update

	void delete(int id);
}
