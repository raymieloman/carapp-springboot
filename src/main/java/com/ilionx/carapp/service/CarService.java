package com.ilionx.carapp.service;

import com.ilionx.carapp.model.Car;
import com.ilionx.carapp.model.Coureur;
import com.ilionx.carapp.persistence.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
// @Transactional // Maakt alle public methods die je VAN BUITEN aanroept Transactioneel
public class CarService {

    @Autowired
    private Coureur maxVerstappen;

    @Autowired
    private Coureur lewisHamilton;

    @Autowired
    public CarRepository carRepository;

    @Value("${companyName}")
    private String companyName;

    public List<Car> findAll() {

        System.out.println("Er is een courier maxie: " + this.maxVerstappen.getName());
        System.out.println("Er is een courier lewis: " + this.lewisHamilton.getName());

        System.out.println("Onze company name is nu: " + this.companyName);

        return carRepository.findAll();
    }

    public List<Car> findAllByOrderByBrand() {
        return this.carRepository.findAllByOrderByBrand();
    }

    @Transactional // Deze start een transactie als hij VAN BUITEN deze class wordt aangeroepen.
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

    public List<Car> findByBrand(String merk) {
        return carRepository.findByBrand(merk);
    }

    public List<Car> findByBrandAndLicensePlate(String brand, String licensePlate) {
        return carRepository.findByBrandAndLicensePlate(brand, licensePlate);
    }

    public List<Car> findByMileageLessThanOrderByBrandAsc(double maxMileage) {
        return carRepository.findByMileageLessThanOrderByBrandAsc(maxMileage);
    }

    public Optional<Car> findByLicensePlate(String licensePlate) {
        return carRepository.findByLicensePlate(licensePlate);
    }
}
