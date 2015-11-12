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

    private final CarOptionRepository carOptionRepository;

    @Autowired
    public CarOptionServiceImpl(CarOptionRepository carOptionRepository) {
        this.carOptionRepository = carOptionRepository;
    }

    @Override
    public List<CarOption> findAllCarOptions() {

        List<CarOption> all = carOptionRepository.findAll();
        return all;
    }

    @Override
    public CarOption getCarOptionById(Long id) {
        return carOptionRepository.findOne(id);
    }

    @Override
    public void createCarOption(CarOption car)  {
        carOptionRepository.save(car);
    }

    @Override
    public void removeCarOption(Long id) {
        carOptionRepository.delete(id);
    }
}
