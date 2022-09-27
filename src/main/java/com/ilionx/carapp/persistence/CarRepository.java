package com.ilionx.carapp.persistence;

import com.ilionx.carapp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByBrand(String merk);
    List<Car> findByBrandAndLicensePlate(String brand, String licensePlate);
    List<Car> findAllByOrderByBrand();
    List<Car> findByMileageLessThanOrderByBrandAsc(double maxMileage);
    Optional<Car> findByLicensePlate(String licensePlate);

}
