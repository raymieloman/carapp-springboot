package com.ilionx.carapp.model;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Duration duration;

    private LocalDateTime dateTimeBuild;

    @Column(nullable = false)
    private String brand;

    private String licensePlate;
    private double mileage;

    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getMileage() {
        return mileage;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public LocalDateTime getDateTimeBuild() {
        return dateTimeBuild;
    }

    public void setDateTimeBuild(LocalDateTime dateTimeBuild) {
        this.dateTimeBuild = dateTimeBuild;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }
}
