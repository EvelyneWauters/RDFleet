package com.realdolmen.rdfleet.webservices.repositories;

import com.realdolmen.rdfleet.entities.car.Car;

import javax.ejb.Remote;

/**
 * Created by JDOAX80 on 10/11/2015.
 */
@Remote
public interface CarRepository {
    void saveCar(Car car);
}
