package com.realdolmen.rdfleet.services.implementations;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.repositories.CarRepository;
import com.realdolmen.rdfleet.repositories.EmployeeRepository;
import com.realdolmen.rdfleet.services.DTO.CarDTO;
import com.realdolmen.rdfleet.services.definitions.CarService;
import com.realdolmen.rdfleet.services.mappers.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by EWTAX45 on 28/10/2015.
 */
@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public final EmployeeRepository employeeRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, EmployeeRepository employeeRepository) {
        this.carRepository = carRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Car> findAll() {
        List<Car> all = carRepository.findAllCarsByNoLongerInUseFalse();
        return all;
    }

    @Override
    public List<Car> findAllNoLongerInUse() {
        List<Car> all = carRepository.findAllCarsByNoLongerInUseTrue();
        return all;
    }

    @Override
    public void createCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void removeCar(Long id) {
        Car car = carRepository.findOne(id);
        car.setNoLongerInUse(true);
        car.setEndLeasing(LocalDate.now());
        Optional<Employee> employeeOpt = employeeRepository.findByCurrentCar(car);
        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            employee.setCurrentCar(null);
            employeeRepository.save(employee);
        }
        carRepository.save(car);
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
