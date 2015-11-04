package com.realdolmen.rdfleet.services;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import com.realdolmen.rdfleet.repositories.CarTypeRepository;
import com.realdolmen.rdfleet.services.implementations.CarServiceImpl;
import com.realdolmen.rdfleet.services.implementations.CarTypeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by JDOAX80 on 2/11/2015.
 */
public class CarTypeServiceImplTest extends ServicesTest {

    private CarTypeServiceImpl carTypeService;
    private CarTypeRepository carTypeRepository;
    private Car car;

    @Before
    public void init() {
        carTypeRepository = Mockito.mock(CarTypeRepository.class);
        carTypeService = new CarTypeServiceImpl(carTypeRepository);
        createNewCar();
    }

    @Test
    public void createOrUpdateCarTypeCanBeCalledFromService() {
        carTypeService.createOrUpdateCarType(car.getCarType());
        Mockito.verify(carTypeRepository).save(car.getCarType());
    }


    @Test
    public void findAllAvailableCarTypesCanBeCalledFromService() {
        carTypeService.findAllAvailableCarTypes();
        Mockito.verify(carTypeRepository).findAll((new Sort(new Sort.Order(Sort.Direction.ASC, "category"))));
    }

    @Test
    public void findByIdCanBeCalledFromService() {
        carTypeService.findById(car.getId());
        Mockito.verify(carTypeRepository).findOne(car.getId());
    }

    @Test
    public void findAllCarTypesCanBeCalledFromService() {
        carTypeService.findAllCarTypes();
        Mockito.verify(carTypeRepository).findAll();
    }

    @Test
    public void removeCarTypeFromListCanBeCalledFromService() {
        Mockito.when(carTypeRepository.findOne(car.getId())).thenReturn(car.getCarType());
        carTypeService.removeCarTypeFromList(car.getId());
        Mockito.verify(carTypeRepository).findOne(car.getId());
        Mockito.verify(carTypeRepository).save(car.getCarType());
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
