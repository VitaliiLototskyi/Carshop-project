package ua.service;

import java.util.List;

import ua.dto.form.ModelForm;
import ua.entity.Model;


public interface ModelService {
	Model findOne(int id);

	List<Model> findAll();

	void save(ModelForm modelForm);// same as update
	ModelForm findForm(int id);

	void delete(int id);

	Model findOne(String name);
	
}
