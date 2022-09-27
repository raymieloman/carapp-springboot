package com.ilionx.carapp.api;

import com.ilionx.carapp.model.Car;
import com.ilionx.carapp.service.CarService;
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
    private CarService carService;

    @ExceptionHandler(DataIntegrityViolationException.class)
    public String errorHandler() {
        return "Badmuts";
    }


    // Hier komt een 200 (OK) uit.
    @GetMapping
    public List<Car> cars() {
        return this.carService.findAll();
    }

    @GetMapping("brand/{brand}")
    public ResponseEntity<List<Car>> findByBrand(@PathVariable("brand") String merk) {
        return ResponseEntity.ok(this.carService.findByBrand(merk));
    }

    @GetMapping("{id}")
    // 200
    public ResponseEntity<Car> findById(@PathVariable long id) {

        Optional<Car> optionalCar = this.carService.findById(id);
        if (optionalCar.isPresent()) {

            return ResponseEntity.ok(optionalCar.get());
        } else {

            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("{id}")
    public ResponseEntity<Car> updateById(@PathVariable long id, @RequestBody Car input) {

        Optional<Car> optionalCar = this.carService.updateById(id, input);
        if (optionalCar.isPresent()) {
            return ResponseEntity.ok(optionalCar.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Car> deleteById(@PathVariable long id) {
        Optional<Car> optionalCar = this.carService.findById(id);
        if (optionalCar.isPresent()) {
            this.carService.deleteById(id);

            return ResponseEntity.noContent().build();
        } else {

            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car create(@RequestBody Car car) {
        Car result = this.carService.save(car);

        return result;
    }

    @GetMapping("order/brand")
    public ResponseEntity<List<Car>> findAllByOrderByBrand() {
        return ResponseEntity.ok(this.carService.findAllByOrderByBrand());
    }
}
