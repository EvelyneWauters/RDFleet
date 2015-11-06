package com.realdolmen.rdfleet.services.implementations;

import com.realdolmen.rdfleet.entities.car.options.CarOption;
import com.realdolmen.rdfleet.repositories.CarOptionRepository;
import com.realdolmen.rdfleet.services.definitions.CarOptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JDOAX80 on 4/11/2015.
 */
@Service
public class CarOptionServiceImpl implements CarOptionsService {
    @Autowired
    private CarOptionRepository carOptionRepository;

    //TODO:Implementatie afwerken
    @Override
    public List<CarOption> findAllCarOptions() {
        return carOptionRepository.findAll();
    }

    @Override
    public CarOption findById(Long id) {
        return null;
    }

    @Override
    public void removeCarOption(Long id) {

    }
}
