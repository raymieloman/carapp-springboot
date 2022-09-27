package com.ilionx.carapp.specs;

import com.ilionx.carapp.model.Car;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class CarSpecification implements Specification<Car> {

    private int maxMileage;

    public CarSpecification(int maxMileage) {
        this.maxMileage = maxMileage;
    }

    @Override
    public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        //  root.<String>get(criteria.getKey()), criteria.getValue().toString());
        return criteriaBuilder.lessThanOrEqualTo(root.get("mileage"), String.valueOf(this.maxMileage));

    }

    public static Specification<Car> hasBookWithTitle(String bookTitle) {

        return new Specification<Car>() {
            @Override
            public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Join<Car, Car> authorsBook = root.join("books");
                return criteriaBuilder.equal(authorsBook.get("title"), bookTitle);
            }
        };
        /*
        return (root, query, criteriaBuilder) -> {
            Join<Car, Car> authorsBook = root.join("books");
            return criteriaBuilder.equal(authorsBook.get("title"), bookTitle);
        };

         */
    }
}
