package com.realdolmen.rdfleet.repositories;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by JDOAX80 on 30/10/2015.
 */
public class CarRepositoryTest extends RepositoryTest {
    @Autowired
    private CarRepository carRepository;

    private Car car;
    private CarType carType;

    @Before
    public void init() {
        CarModel carModel = new CarModel();
        carModel.setModelName("A6");
        Brand brand = new Brand();
        brand.setName("Audi");
        car = new Car();
        carType = new CarType();
        carType.setCarModel(carModel);
        carType.setBrand(brand);
    }

    @Test
    public void carCanBeCreated() {
        car.setCarType(carType);
        carRepository.save(car);
    }

    @Test
    public void carCantBeCreatedWithoutCarType() {

    }

    @Test
    public void vinNumberOfCarMustBeUnique() {

    }
}
