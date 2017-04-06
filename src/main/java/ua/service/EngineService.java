package ua.service;

import java.util.List;

import ua.dto.form.EngineForm;
import ua.dto.form.ModelForm;
import ua.entity.Engine;

public interface EngineService {
	Engine findOne(int id);

	List<Engine> findAll();

	void save(EngineForm engine);// same as update
	EngineForm findForm(int id);
	void delete(int id);
}
