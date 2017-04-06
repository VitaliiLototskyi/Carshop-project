package ua.service;

import java.util.List;

import ua.entity.Country;


public interface CountryService {
Country findOne(int id);

	List<Country> findAll();

	void save(Country country);// same as update

	void delete(int id);

	Country findOne(String name);
}
