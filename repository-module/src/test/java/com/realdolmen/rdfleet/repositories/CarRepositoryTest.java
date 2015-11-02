package com.realdolmen.rdfleet.repositories;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import javax.persistence.UniqueConstraint;
import javax.validation.ConstraintViolationException;

/**
 * Created by JDOAX80 on 30/10/2015.
 */
public class CarRepositoryTest extends RepositoryTest {
    @Autowired
    private CarRepository carRepository;

    private Car car;
    private Car car2;
    private CarType carType;
    private CarType carType2;

    @Before
    public void init() {
        CarModel carModel = new CarModel();
        carModel.setModelName("A6");
        Brand brand = new Brand();
        brand.setName("Audi");
        car = new Car();
        car2 = new Car();
        carType = new CarType();
        carType2 = new CarType();
        carType.setCarModel(carModel);
        carType2.setCarModel(carModel);
        carType.setBrand(brand);
        carType2.setBrand(brand);
    }

    @Test
    public void carCanBeCreated() {
        car.setCarType(carType);
        carRepository.save(car);
    }

    @Test(expected = ConstraintViolationException.class)
    public void carCantBeCreatedWithoutCarType() {
        carRepository.save(car);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void vinNumberOfCarMustBeUnique() {
        car.setCarType(carType);
        car2.setCarType(carType2);
        car.setVinNumber("145");
        car2.setVinNumber("145");
        carRepository.save(car);
        carRepository.save(car2);
    }
}
