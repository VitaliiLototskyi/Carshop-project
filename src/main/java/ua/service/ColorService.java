package ua.service;

import java.util.List;

import ua.entity.Color;

public interface ColorService {
	Color findOne(int id);
	List<Color> findAll();

	void save(Color color);// same as update

	void delete(int id);

	Color findOne(String color);
}
