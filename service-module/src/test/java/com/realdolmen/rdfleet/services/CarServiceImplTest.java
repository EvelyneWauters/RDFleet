package com.realdolmen.rdfleet.services;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.repositories.CarRepository;
import com.realdolmen.rdfleet.repositories.CarTypeRepository;
import com.realdolmen.rdfleet.repositories.EmployeeRepository;
import com.realdolmen.rdfleet.services.DTO.CarDTO;
import com.realdolmen.rdfleet.services.implementations.CarServiceImpl;
import com.realdolmen.rdfleet.services.implementations.CarTypeServiceImpl;
import com.realdolmen.rdfleet.services.implementations.EmployeeServiceImpl;
import com.realdolmen.rdfleet.services.mappers.CarMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;

/**
 * Created by JDOAX80 on 2/11/2015.
 */
public class CarServiceImplTest {

    private CarServiceImpl carService;
    private CarRepository carRepository;
    private EmployeeRepository employeeRepository;
    private Car car;

    @Before
    public void init() {
        carRepository = mock(CarRepository.class);
        employeeRepository = mock(EmployeeRepository.class);
        carService = new CarServiceImpl(carRepository, employeeRepository);
        createNewCar();
    }

    @Test
    public void createCarCanBeSuccessfullyCalledFromService() {
        carService.createCar(car);
        verify(carRepository).save(car);
    }

    @Test
    public void removeCarCanBeSuccessfullyCalledFromService() {
        when(employeeRepository.findByCurrentCar(car)).thenReturn(Optional.ofNullable(new Employee()));
        when(carRepository.findOne(1L)).thenReturn(car);
        carService.removeCar(car.getId());
        verify(employeeRepository).findByCurrentCar(any(Car.class));
        verify(employeeRepository).save(any(Employee.class));
    }

    @Test
    public void findAllCanBeSuccessfullyCalledFromService() {
       when(carRepository.findAll()).thenReturn(null);
       carService.findAll();
       verify(carRepository).findAllCarsByNoLongerInUseFalse();
    }

    @Test
    public void findAllCarsInTheFreePoolCanBeSuccessfullyCalledFromService() {
        when(carRepository.findAllCarsByInThePoolTrue()).thenReturn(new ArrayList<Car>());
        carService.findCarsInTheFreePool();
        verify(carRepository).findAllCarsByInThePoolTrue();
    }

    @Test
    public void findByIdCanBeSuccessfullyCalledFromService() {
        when(carRepository.findOne(1L)).thenReturn(car);
        carService.findById(1L);
        verify(carRepository).findOne(1L);
    }

    public void createNewCar() {
        car = new Car();
        car.setId(1L);
        CarModel carModel = new CarModel();
        carModel.setModelName("A6");
        Brand brand = new Brand();
        brand.setName("Audi");
        CarType carType = new CarType();
        carType.setCarModel(carModel);
        carType.setBrand(brand);
        car.setCarType(carType);
    }
}
