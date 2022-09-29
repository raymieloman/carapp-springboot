package com.ilionx.carapp.service;

import com.ilionx.carapp.model.Car;
import com.ilionx.carapp.persistence.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @InjectMocks
    private CarService carService;

    @Mock
    private CarRepository carRepository;

    @Test
    public void testSave() {

        // Given
        Car carInput = new Car();
        carInput.setMileage(123);
        carInput.setBrand("Kia");
        carInput.setLicensePlate("GZ-120-K");

        Mockito.when(this.carRepository.save(carInput)).thenReturn(carInput);

        // When
        Car result = this.carService.save(carInput);

        // Then
        assertEquals(123, result.getMileage());
    }

    // oefening, maak dit zelf verder af
    @Test
    public void testFindAll() {
        // Given
        Car c = new Car();

        // Mock the carRepository zijn findAll

        // When
        List<Car> resultFromService = this.carService.findAll();

        // Then
        assertEquals(1, resultFromService.size());
    }
}
