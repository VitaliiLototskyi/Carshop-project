package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Model;

public interface ModelRepository extends JpaRepository<Model, Integer>{
	@Query("SELECT i FROM Model i LEFT JOIN FETCH i.producer LEFT JOIN FETCH i.engine")
	List<Model> findAll();
	@Query("SELECT i FROM Model i LEFT JOIN FETCH i.producer LEFT JOIN FETCH i.engine WHERE i.id = ?1")
	Model findOne(Integer id);

	Model findByName(String name);
}

