package ua.service.implementation;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.dto.form.ModelForm;
import ua.entity.Model;
import ua.repository.EngineRepository;
import ua.repository.ModelRepository;
import ua.repository.ProducerRepository;
import ua.service.ModelService;
@Service
public class ModelServiceImpl implements ModelService{
	@Autowired
	private ModelRepository repository;
	

	@Override
	@Transactional(readOnly = true)
	public Model findOne(int id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Model> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void save(ModelForm modelForm) {
		Model model = new Model();
		model.setId(modelForm.getId());
		model.setEngine(modelForm.getEngine());
		model.setName(modelForm.getName());
		model.setPrice(new BigDecimal(modelForm.getPrice().replace(',', '.')));
		model.setProducer(modelForm.getProducer());
		repository.save(model);
	}
	@Override
	public ModelForm findForm(int id) {
		Model model = repository.findOne(id);
		ModelForm modelForm = new ModelForm();
		modelForm.setId(model.getId());
		modelForm.setEngine(model.getEngine());
		modelForm.setName(model.getName());
		modelForm.setPrice(String.valueOf(model.getPrice()));
		modelForm.setProducer(model.getProducer());
		return modelForm;
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
	}

	
	@Override
	public Model findOne(String name) {
		return repository.findByName(name);
	}

	
}
