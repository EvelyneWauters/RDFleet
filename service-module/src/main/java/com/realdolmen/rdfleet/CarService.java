package com.realdolmen.rdfleet;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by EWTAX45 on 28/10/2015.
 */
@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> findAll()  {
       return carRepository.findAll();
    }

    public void createCar(Car car)  {
        carRepository.save(car);
    }

    public void removeCar(Long id) {
        carRepository.delete(id);
    }


}