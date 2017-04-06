package ua.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Integer>,JpaSpecificationExecutor<Producer> {
	@Query("SELECT p FROM Producer p LEFT JOIN FETCH p.country WHERE p.id = ?1")
	Producer findOne(Integer id);

	Producer findByName(String name);
	Page<Producer> findAll(Pageable pageable);
}
