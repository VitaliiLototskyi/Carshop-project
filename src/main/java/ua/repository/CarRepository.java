package ua.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer>, JpaSpecificationExecutor<Car> {
	@Query("SELECT i FROM Car i LEFT JOIN FETCH i.model m LEFT JOIN FETCH m.engine LEFT JOIN FETCH i.gearBox LEFT JOIN FETCH i.color WHERE i.id = ?1")
	Car findOne(Integer id);
//	@Query("SELECT i FROM Car i LEFT JOIN FETCH i.model LEFT JOIN FETCH i.gearBox LEFT JOIN FETCH i.bodyStyle")
//	List<Car> findAll();
	Car findByName(String name);
	
	
	
	@Query(value="SELECT i FROM Car i LEFT JOIN FETCH i.model LEFT JOIN FETCH i.gearBox",
			countQuery="SELECT count(i.id) FROM Car i")
	
	
	Page<Car> findAll(Pageable pageable);
	
//	@Query("SELECT i FROM Car i LEFT JOIN FETCH i.model m LEFT JOIN FETCH m.price LEFT JOIN FETCH i.gearBox LEFT JOIN FETCH i.color WHERE i.id = ?1") 
//	Car findOne(Integer id); 
//	// @Query("SELECT i FROM Car i LEFT JOIN FETCH i.model LEFT JOIN FETCH i.gearBox LEFT JOIN FETCH i.bodyStyle") 
//	// List<Car> findAll(); 
//	Car findByName(String name); 
//
//
//
//	@Query(value="SELECT i FROM Car i LEFT JOIN FETCH i.model m LEFT JOIN FETCH m.price LEFT JOIN FETCH i.gearBox", 
//	countQuery="SELECT count(i.id) FROM Car i") 
//
//
//	Page<Car> findAll(Pageable pageable);
	
}
