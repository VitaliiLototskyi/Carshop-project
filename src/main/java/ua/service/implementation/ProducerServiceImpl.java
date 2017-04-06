package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.dto.filter.BasicFilter;
import ua.entity.Producer;
import ua.repository.ProducerRepository;
import ua.service.ProducerService;
import ua.service.specification.CarSpecification;
import ua.service.specification.ProducerSpecification;
@Service
public class ProducerServiceImpl implements ProducerService{
	@Autowired
	private ProducerRepository repository;

	@Override
	@Transactional(readOnly = true)
	public Producer findOne(int id) {
		return repository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producer> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Producer producer) {
		repository.save(producer);
	}

	@Override
	public void delete(int id) {
		repository.delete(id);
	}

	@Override
	public Producer findOne(String name) {
		return repository.findByName(name);
	}

	@Override
	public Page<Producer> findAll(BasicFilter filter, Pageable pageable) {
		return repository.findAll(new ProducerSpecification(filter), pageable);
	}
	
}
