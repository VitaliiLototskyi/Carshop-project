package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.filter.BasicFilter;
import ua.dto.filter.CarFilter;
import ua.dto.form.CarForm;
import ua.entity.Car;

public interface CarService {
	Car findOne(int id);

	List<Car> findAll();

//	void save(Car car);// same as update
	void save(CarForm carForm);
	CarForm findForm(int id);
	void delete(int id);

	Car findOne(String name);
	Page<Car> findAll(CarFilter filter, Pageable pageable);
}
