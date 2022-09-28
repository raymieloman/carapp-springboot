package com.ilionx.carapp.beans;

import com.ilionx.carapp.model.Car;
import com.ilionx.carapp.model.Coureur;
import com.ilionx.carapp.persistence.CarRepository;
import com.ilionx.carapp.service.CarService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public Coureur maxVerstappen() {


        CarService s = new CarService();
        s.save(new Car());

        Coureur max = new Coureur();
        max.setName("Max Verstappen");

        return max;
    }

    @Bean
    public Coureur lewisHamilton() {
        Coureur lewis = new Coureur();
        lewis.setName("Lewis Hamilton");

        return lewis;
    }
}
