package com.realdolmen.rdfleet.services.definitions;

import com.realdolmen.rdfleet.entities.car.CarType;

import java.util.List;

/**
 * Created by JDOAX80 on 30/10/2015.
 */
public interface CarTypeService {
    List<CarType> findAllCarTypes();

    List<CarType> findAllAvailableCarTypes();

    CarType findById(Long id);

    void createOrUpdateCarType(CarType car);

    void removeCarTypeFromList(Long id);

}
