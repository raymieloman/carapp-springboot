package com.ilionx.carapp.specs;

import com.ilionx.carapp.model.Car;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CarSpecification implements Specification<Car> {

    private int maxMileage;

    public CarSpecification(int maxMileage) {
        this.maxMileage = maxMileage;
    }

    @Override
    public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        //  root.<String>get(criteria.getKey()), criteria.getValue().toString());
        return criteriaBuilder.lessThanOrEqualTo(root.<String>get("mileage"), String.valueOf(this.maxMileage));
    }
}
