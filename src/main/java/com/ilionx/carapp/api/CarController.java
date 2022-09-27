package com.ilionx.carapp.api;

import com.ilionx.carapp.model.Car;
import com.ilionx.carapp.persistence.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @ExceptionHandler(DataIntegrityViolationException.class)
    public String errorHandler() {
        return "Badmuts";
    }


    // Hier komt een 200 (OK) uit.
    @GetMapping
    public List<Car> cars() {

        return this.carRepository.findAll();
    }

    @GetMapping("{id}")
    // 200
    public ResponseEntity<Car> findById(@PathVariable long id) {

        Optional<Car> optionalCar = this.carRepository.findById(id);
        if (optionalCar.isPresent()) {

            return ResponseEntity.ok(optionalCar.get());
        } else {

            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("{id}")
    public ResponseEntity<Car> updateById(@PathVariable long id, @RequestBody Car input) {
        Optional<Car> optionalCar = this.carRepository.findById(id);
        if (optionalCar.isPresent()) {
            Car target = optionalCar.get();
            target.setLicensePlate(input.getLicensePlate());
            target.setBrand(input.getBrand());
            target.setLicensePlate(input.getLicensePlate());

            return ResponseEntity.ok(this.carRepository.save(target));
        } else {

            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Car> deleteById(@PathVariable long id) {
        Optional<Car> optionalCar = this.carRepository.findById(id);
        if (optionalCar.isPresent()) {
            this.carRepository.deleteById(id);

            return ResponseEntity.noContent().build();
        } else {

            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car create(@RequestBody Car car) {
        Car result = this.carRepository.save(car);
        
        return result;
    }
}
