package com.realdolmen.rdfleet.services.implementations;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.repositories.CarRepository;
import com.realdolmen.rdfleet.services.definitions.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by EWTAX45 on 28/10/2015.
 */
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> findAll()  {
        List<Car> all = carRepository.findAll();
        return all;
    }

    @Override
    public void createCar(Car car)  {
        carRepository.save(car);
    }

    @Override
    public void removeCar(Long id) {
        carRepository.delete(id);
    }


}
