package com.realdolmen.rdfleet.entities;

import com.realdolmen.rdfleet.entities.car.CarType;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by JDOAX80 on 30/10/2015.
 */
public class CarTypeEntityTest extends Assert {

    @Test(expected = IllegalArgumentException.class)
    public void carTypeCategoryCantBeLowerThanOne() {
        CarType carType = new CarType();
        carType.setCategory(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void carTypeCategoryCantBeHigherThanSeven() {
        CarType carType = new CarType();
        carType.setCategory(8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void carTypeCategoryCantBeNegative() {
        CarType carType = new CarType();
        carType.setCategory(-1);
    }
}
