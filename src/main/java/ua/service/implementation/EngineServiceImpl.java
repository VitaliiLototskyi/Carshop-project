package ua.service.implementation;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.dto.form.EngineForm;
import ua.entity.Engine;
import ua.repository.EngineRepository;
import ua.service.EngineService;

@Service
public class EngineServiceImpl implements EngineService{
	@Autowired
	private EngineRepository repository;
	@Override
	@Transactional(readOnly = true)//���� �����  ���� ���� � ���� ��a��� Transaction!
	public Engine findOne(int id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)//���� �����  ���� ���� � ���� ��a��� Transaction!
	public List<Engine> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void save(EngineForm engineForm) {
		Engine engine = new Engine();
		engine.setId(engineForm.getId());
		engine.setSweptVolume(new BigDecimal(engineForm.getSweptVolume().replace(',', '.')));
		engine.setEngineType(engineForm.getEngineType());
		repository.save(engine);
	}
	@Override
	public EngineForm findForm(int id) {
		Engine engine = repository.findOne(id);
		EngineForm engineForm = new EngineForm();
		engineForm.setId(engine.getId());
		engineForm.setSweptVolume(String.valueOf(engine.getSweptVolume()));
		engineForm.setEngineType(engine.getEngineType());
		return engineForm;
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
	}

	

	

}
