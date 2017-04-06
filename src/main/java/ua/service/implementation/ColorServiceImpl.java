package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Color;
import ua.entity.Country;
import ua.repository.ColorRepository;
import ua.service.ColorService;
@Service
public class ColorServiceImpl implements ColorService{
	@Autowired
	private ColorRepository repository;

	@Override
	@Transactional(readOnly = true)
	public Color findOne(int id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Color> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Color color) {
		repository.save(color);
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
	}

	@Override
	public Color findOne(String color) {
		return repository.findByColor(color);
	}

}
