package com.ilionx.carapp.api;

import com.ilionx.carapp.model.Car;
import com.ilionx.carapp.persistence.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public List<Car> cars() {
        return this.carRepository.findAll();
    }

    @PostMapping
    public Car create(@RequestBody Car car) {

        Car result = this.carRepository.save(car);

        return result;
    }
}
