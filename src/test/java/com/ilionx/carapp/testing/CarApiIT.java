package com.ilionx.carapp.testing;

import com.ilionx.carapp.model.Car;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integrationtest")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarApiIT {

    @Autowired
    private TestRestTemplate restTemplate;

    public static final String url = "/api/cars";

    private static long currentId = -1;


    @Test
    @Order(1)
    public void testSaving() {

        // Given
        Car car = new Car();
        car.setLicensePlate("GZ120H");
        car.setBrand("Kia");
        car.setMileage(97001);

        // When
        ResponseEntity<Car> response  = this.restTemplate.postForEntity(url, car, Car.class);

        // Then
        assertEquals(201, response.getStatusCodeValue());
        Car returnedCar = response.getBody();
        assertNotNull(returnedCar);
        assertNotEquals(0, returnedCar.getId());
        assertEquals("Kia", returnedCar.getBrand());
        currentId = returnedCar.getId();
    }

    @Test
    @Order(2)
    public void testGetById() {

        // When

        ResponseEntity<Car> response  = this.restTemplate.getForEntity(url+"/"+currentId, Car.class);

        // Then
        assertNotNull(response.getBody());
        Car responsedCar = response.getBody();
        assertEquals(97001, responsedCar.getMileage());
    }
}
