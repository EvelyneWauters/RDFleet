package com.realdolmen.rdfleet.repositories;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;
import java.util.List;

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
        super.init();
        carModel = new CarModel();
        carModel.setModelName("A6");
        brand = new Brand();
        brand.setName("Audi");
        carType = new CarType();
    }

    @Test
    public void carTypeCanBeCreated() {
        carType.setBrand(brand);
        carType.setCategory(1);
        carType.setCarModel(carModel);
        carTypeRepository.save(carType);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void carTypeCantBeCreatedWithoutBrand() {
        carType.setCarModel(carModel);
        carTypeRepository.save(carType);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void carTypeCantBeCreatedWithoutModel() {
        carType.setBrand(brand);
        carTypeRepository.save(carType);
    }

    @Test
    public void findCarTypeByCategoryCanBeSuccessfullyCalled() {
        List<CarType> carTypes = carTypeRepository.findCarTypeByCategory(1);
        assertEquals(1, carTypes.size());
    }

    @Test
    public void findCarTypeByCategoryReturnsNoCarTypesWhenGivenAnInvalidCategory() {
        List<CarType> carTypes = carTypeRepository.findCarTypeByCategory(8);
        assertEquals(0, carTypes.size());
    }


    @Test
    public void findAllByIsAvailableTrueCanBeSuccessfullyCalled() {
        List<CarType> carTypes = carTypeRepository.findAllByIsAvailableTrue();
        assertEquals(1, carTypes.size());
    }

    @Test
    public void findAllByIsAvailableTrueReturnsNoCarTypesIfNoneAreAvailable() {
        CarType carType = getCarType();
        carType.setIsAvailable(false);
        carTypeRepository.save(carType);
        List<CarType> carTypes = carTypeRepository.findAllByIsAvailableTrue();
        assertEquals(0, carTypes.size());
    }
}
