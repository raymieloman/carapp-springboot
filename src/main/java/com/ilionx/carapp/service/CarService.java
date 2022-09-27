package com.ilionx.carapp.service;

import com.ilionx.carapp.model.Car;
import com.ilionx.carapp.persistence.CarRepository;
import com.ilionx.carapp.specs.CarSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.findAll(new CarSpecification(10000));
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public Optional<Car> findById(Long aLong) {
        return carRepository.findById(aLong);
    }

    public long count() {
        return carRepository.count();
    }

    public void deleteById(Long aLong) {
        carRepository.deleteById(aLong);
    }

    public Optional<Car> updateById(long id, Car input) {
        Optional<Car> optionalCar = this.carRepository.findById(id);
        if (optionalCar.isPresent()) {
            Car target = optionalCar.get();
            target.setLicensePlate(input.getLicensePlate());
            target.setBrand(input.getBrand());
            target.setLicensePlate(input.getLicensePlate());

            this.carRepository.save(target);
        }
        return optionalCar;
    }
}
