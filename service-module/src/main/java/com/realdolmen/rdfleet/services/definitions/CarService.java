package com.realdolmen.rdfleet.services.definitions;

import com.realdolmen.rdfleet.entities.car.Car;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by JDOAX80 on 30/10/2015.
 */
public interface CarService {
    List<Car> findAll();

    void createCar(Car car);

    void removeCar(Long id);
}
