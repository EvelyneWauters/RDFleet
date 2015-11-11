package com.realdolmen.rdfleet.services.implementations;

import com.realdolmen.rdfleet.DTO.CarDTO;
import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.repositories.CarRepository;
import com.realdolmen.rdfleet.services.definitions.CarService;
import com.realdolmen.rdfleet.services.mappers.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EWTAX45 on 28/10/2015.
 */
@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

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

    @Override
    public List<CarDTO> findCarsInTheFreePool() {
        List<Car> allCarsByIsInThePoolTrue = carRepository.findAllCarsByInThePoolTrue();
        List<CarDTO> carDTOList = new ArrayList<>();
        for (Car car : allCarsByIsInThePoolTrue) {
           carDTOList.add(CarMapper.mapCarObjectToCarDTO(car));
        }
        return carDTOList;
    }

    @Override
    public CarDTO findById(Long id) {
        Car car = carRepository.findOne(id);
        CarDTO carDTO = CarMapper.mapCarObjectToCarDTO(car);
        return carDTO;
//        return CarMapper.mapCarObjectToCarDTO(carRepository.findOne(id));
    }


}
