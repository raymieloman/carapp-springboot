package com.ilionx.carapp.persistence;

import com.ilionx.carapp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
    public interface CarRepository extends JpaRepository<Car, Long>, JpaSpecificationExecutor<Car> {
    List<Car> findByBrand(String merk);

    List<Car> findByBrandAndLicensePlate(String brand, String licensePlate);

    List<Car> findAllByOrderByBrand();

    List<Car> findByMileageLessThanOrderByBrandAsc(double maxMileage);

    Optional<Car> findByLicensePlate(String licensePlate);
    @Query("select car from Car car where car.brand like %?1% and car.mileage < ?2") // let op: dit is JPQL
    List<Car> lijstCarsVanMerk(String merk, int mileage);

    // Native Query dus standaard SQL
    @Query(value = "SELECT * from CAR WHERE id is not null", nativeQuery = true)
    List<Car> listCarsDieOphaalbaarZijnMetEenMoeilijkeQuery();
}
