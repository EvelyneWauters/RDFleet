package com.realdolmen.rdfleet.repositories;

import com.realdolmen.rdfleet.entities.car.options.CarOption;
import com.realdolmen.rdfleet.entities.car.options.CruiseControl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolationException;

/**
 * Created by JDOAX80 on 4/11/2015.
 */
public class CarOptionRepositoryTest extends RepositoryTest {
    @Autowired
    private CarOptionRepository carOptionRepository;

    @Test(expected = ConstraintViolationException.class)
    public void carOptionCantBeCreatedWithoutOptionName() {
        CarOption carOption = new CarOption();
        carOptionRepository.save(carOption);
    }

}
