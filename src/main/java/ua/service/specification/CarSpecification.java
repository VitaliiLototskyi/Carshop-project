package ua.service.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.dto.filter.CarFilter;
import ua.entity.Car;
import ua.entity.Color;
import ua.entity.Engine;
import ua.entity.Model;
import ua.entity.Producer;

public class CarSpecification implements Specification<Car> {
	private final CarFilter filter;
	private final List<Predicate> predicates = new ArrayList<>();

	public CarSpecification(CarFilter filter) {
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		fetch(root, query);
		filterByPrice(root, query, cb);
		filterBySearch(root, query, cb);
		filterByProducer(root, query, cb);
		filterByYear(root, query, cb);
		filterByColor(root, query, cb);
		if (predicates.isEmpty())
			return null;
		Predicate[] array = new Predicate[predicates.size()];
		predicates.toArray(array);
		return cb.and(array);
	}

	private void fetch(Root<Car> root, CriteriaQuery<?> query) {
		if (query.getResultType() != Long.class) {
			Fetch<Car, Model> fetch = root.fetch("model", JoinType.LEFT);
			Fetch<Car, Producer> fetch2 = fetch.fetch("producer");
			Fetch<Car, Engine> fetch4 = fetch.fetch("engine", JoinType.LEFT);
			fetch2.fetch("country");
			fetch.fetch("engine");
			root.fetch("model", JoinType.LEFT);
			root.fetch("gearBox", JoinType.LEFT);
			root.fetch("color", JoinType.LEFT);
		}
	}

	// private void fetch(Root<Car> root, CriteriaQuery<?> query) {
	// if (query.getResultType() != Long.class) {
	// Fetch<Car, Model> fetch = root.fetch("model", JoinType.LEFT);
	// fetch.fetch("price", JoinType.LEFT);
	// Fetch<Car, Producer> fetch2 = fetch.fetch("producer");
	// fetch2.fetch("country");
	// fetch.fetch("engine");
	// root.fetch("model", JoinType.LEFT);
	// root.fetch("gearBox", JoinType.LEFT);
	// root.fetch("color", JoinType.LEFT);
	// }
	// }

	private void filterByPrice(Root<Car> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (filter.getMax() != null && filter.getMin() != null) {
			Join<Object, Object> join = root.join("model");
			predicates.add(cb.between(join.get("price"), filter.getMin(),
					filter.getMax()));
		} else if (filter.getMax() != null) {
			Join<Object, Object> join = root.join("model");
			predicates.add(cb.lessThanOrEqualTo(join.get("price"),
					filter.getMax()));
		} else if (filter.getMin() != null) {
			Join<Object, Object> join = root.join("model");
			predicates.add(cb.greaterThanOrEqualTo(join.get("price"),
					filter.getMin()));
		}
	}

	private void filterBySearch(Root<Car> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (!filter.getSearch().isEmpty()) {
			predicates.add(cb.like(root.get("name"), filter.getSearch() + "%"));
		}
	}

	private void filterByProducer(Root<Car> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (!filter.getProducerIds().isEmpty()) {
			Join<Car, Model> join = root.join("model");
			Join<Model, Producer> join2 = join.join("producer");
			predicates.add(join2.get("id").in(filter.getProducerIds()));
		}
	}

	private void filterByYear(Root<Car> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (filter.getMaxiYear() != null && filter.getMiniYear() != null) {
			predicates.add(cb.between(root.get("year"), filter.getMiniYear(),
					filter.getMaxiYear()));
		} else if (filter.getMaxiYear() != null) {
			predicates.add(cb.lessThanOrEqualTo(root.get("year"),
					filter.getMaxiYear()));
		} else if (filter.getMiniYear() != null) {
			predicates.add(cb.greaterThanOrEqualTo(root.get("year"),
					filter.getMiniYear()));
		}
	}

	private void filterByColor(Root<Car> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (!filter.getColorIds().isEmpty()) {
			Join<Car, Color> join = root.join("color");
			predicates.add(join.get("id").in(filter.getColorIds()));
		}
	}

}
