package com.realdolmen.rdfleet.services;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import com.realdolmen.rdfleet.repositories.CarRepository;
import com.realdolmen.rdfleet.repositories.CarTypeRepository;
import com.realdolmen.rdfleet.services.implementations.CarServiceImpl;
import com.realdolmen.rdfleet.services.implementations.CarTypeServiceImpl;
import com.realdolmen.rdfleet.services.implementations.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;

/**
 * Created by JDOAX80 on 2/11/2015.
 */
public class CarServiceImplTest extends ServicesTest {

    private CarServiceImpl carService;
    private CarRepository carRepository;
    private Car car;

    @Before
    public void init() {
        carRepository = mock(CarRepository.class);
        carService = new CarServiceImpl(carRepository);
        createNewCar();
    }

    @Test
    public void createCarCanBeSuccessfullyCalledFromService() {
        carService.createCar(car);
        verify(carRepository).save(car);
    }

    @Test
    public void removeCarCanBeSuccessfullyCalledFromService() {
        carService.removeCar(car.getId());
        verify(carRepository).delete(car.getId());
    }

    @Test
    public void findAllCanBeSuccessfullyCalledFromService() {
       when(carRepository.findAll()).thenReturn(null);
       carService.findAll();
       verify(carRepository).findAll();
    }

    public void createNewCar() {
        car = new Car();
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
