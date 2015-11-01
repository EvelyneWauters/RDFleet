package com.realdolmen.rdfleet.repositories;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PersistenceException;

/**
 * Created by JDOAX80 on 30/10/2015.
 */
public class CarTypeRepositoryTest extends RepositoryTest {
    @Autowired
    private CarTypeRepository carTypeRepository;

    private CarType carType;
    private Brand brand;
    private CarModel carModel;

    @Before
    public void init() {
        carModel = new CarModel();
        carModel.setModelName("A6");
        brand = new Brand();
        brand.setName("Audi");
        carType = new CarType();
    }

    @Test
    public void carTypeCanBeCreated() {
        carTypeRepository.save(carType);
    }

    @Test(expected = PersistenceException.class)
    public void carTypeCantBeCreatedWithoutBrand() {
        carType.setCarModel(carModel);
        carTypeRepository.save(carType);
    }

    @Test(expected = PersistenceException.class)
    public void carTypeCantBeCreatedWithoutModel() {
        carType.setBrand(brand);
        carTypeRepository.save(carType);
    }
}