package com.realdolmen.rdfleet.services.definitions;


import com.realdolmen.rdfleet.entities.car.options.CarOption;

import java.util.List;

/**
 * Created by JDOAX80 on 4/11/2015.
 */
public interface CarOptionsService {

    List<CarOption> findAllCarOptions();

    CarOption getCarOptionById(Long id);

    void createCarOption(CarOption carOption);

    void removeCarOption(Long id);
}
