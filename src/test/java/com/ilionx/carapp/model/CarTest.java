package com.ilionx.carapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CarTest {

    private Car car;

    @BeforeEach
    public void setup() {
        car = new Car();
    }

    @Test
    public void testGetSetBrand() {

        // Given
        // I have the car created above

        // When
        car.setBrand("Mercedes");
        // Then
        assertEquals("Mercedes", car.getBrand());
    }

    @Test
    public void testGetSetMileage() {
        car.setMileage(123);
        assertEquals(123, car.getMileage());
    }

    @Test
    public void testGetSetLicensePlate() {
        car.setLicensePlate("AABBCC");
        assertEquals("AABBCC", car.getLicensePlate());
    }
}
