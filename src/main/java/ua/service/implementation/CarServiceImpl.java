package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.dto.filter.CarFilter;
import ua.dto.form.CarForm;
import ua.entity.Car;
import ua.repository.CarRepository;
import ua.service.CarService;
import ua.service.FileWriter;
import ua.service.FileWriter.Folder;
import ua.service.specification.CarSpecification;

@Service
public class CarServiceImpl implements CarService {
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private FileWriter fileWriter;

	@Override
	@Transactional(readOnly = true)//���� �����  ���� ���� � ���� ��a��� Transaction! 
	public Car findOne(int id) {
		return carRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Car> findAll() {
		return carRepository.findAll();
	}

//	@Override
//	public void save(Car car) {
//		repository.saveAndFlush(car);
//		if(fileWriter.write(Folder.CAR, car.getFile(), car.getId())){
//			if(car.getVersion()==null)car.setVersion(0);
//			else car.setVersion(car.getVersion()+1);
//		}
//		repository.save(car);
//	}

	@Override
	public void delete(int id) {
		carRepository.delete(id);
	}

	@Override
	public Car findOne(String name) {
		return carRepository.findByName(name);
	}

	@Override
	public Page<Car> findAll(CarFilter filter, Pageable pageable) {
		Page<Car> cars = carRepository.findAll(new CarSpecification(filter), pageable);
		return cars;
		
	}

	@Override
	@Transactional 
	public void save(CarForm carForm) {
		Car car = new Car();
		car.setId(carForm.getId());
		car.setBodyStyle(carForm.getBodyStyle());
		car.setModel(carForm.getModel());
		car.setGearBox(carForm.getGearBox());
		car.setYear(Integer.valueOf(carForm.getYear()));
		car.setName(carForm.getName());
		car.setColor(carForm.getColor());
		car.setVersion(carForm.getVersion());
		
//		carRepository.saveAndFlush(car);
		if(fileWriter.write(Folder.CAR, carForm.getFile(), car.getId())){
			if(car.getVersion()==null)car.setVersion(0);
			else car.setVersion(car.getVersion()+1);
		}
		carRepository.saveAndFlush(car);
	}

	@Override
	@Transactional (readOnly=true) 
	public CarForm findForm(int id) {
		Car car = carRepository.findOne(id);
		CarForm carForm = new CarForm();
		carForm.setBodyStyle(car.getBodyStyle());
		carForm.setGearBox(car.getGearBox());
		carForm.setId(car.getId());
		carForm.setModel(car.getModel());
		carForm.setName(car.getName());
		carForm.setColor(car.getColor());
		carForm.setVersion(car.getVersion());
		carForm.setYear(String.valueOf(car.getYear()));
		return carForm;
	}
}
