package com.realdolmen.rdfleet;

import com.realdolmen.rdfleet.entities.Car;
import com.realdolmen.rdfleet.repositories.CarRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class ApplicationConfiguration {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ApplicationConfiguration.class).profiles("production").run();
        CarRepository repository = context.getBean(CarRepository.class);
        Car car = new Car();
        car.setMileage(55000);
        car.setAmountOfRefuels(70);
        repository.save(car);
    }
}

