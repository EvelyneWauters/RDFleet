package com.realdolmen.rdfleet.services.implementations;

import com.realdolmen.rdfleet.DTO.CarTypeDTO;
import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.repositories.CarRepository;
import com.realdolmen.rdfleet.repositories.CarTypeRepository;
import com.realdolmen.rdfleet.services.definitions.CarTypeService;
import com.realdolmen.rdfleet.services.mappers.CarTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by EWTAX45 on 30/10/2015.
 */
@Service
public class CarTypeServiceImpl implements CarTypeService{

    private final CarTypeRepository carTypeRepository;

    @Autowired
    public CarTypeServiceImpl(CarTypeRepository carTypeRepository) {
        this.carTypeRepository = carTypeRepository;
    }

//    @Override
//    public List<CarType> findAllCarTypes()  {
//        return carTypeRepository.findAll();
//    }
//
//
//    @Override
//    public List<CarType> findCarByFunctionalLevel(int i)    {
//        return carTypeRepository.findCarTypeByCategory(i);
//    }
//
//
//    @Override
//    public List<CarType> findAllAvailableCarTypes()  {
//        List<CarType> catalog = carTypeRepository.findAllByIsAvailableTrue();
//        return catalog;
//    }

    @Override
    public CarType findById(Long id)    {
        return carTypeRepository.findOne(id);
    }

    @Override
    public void createOrUpdateCarType(CarType carType)  {
        checkIfValidEntity(carType);
        carTypeRepository.save(carType);
    }

    //will not remove the CarType, but set the 'is available'-flag to false
    @Override
    public void removeCarTypeFromList(Long id) {
        CarType carType = carTypeRepository.findOne(id);
        carType.setIsAvailable(false);
        if (carType != null) {
            createOrUpdateCarType(carType);
        }
    }

    public boolean checkIfValidEntity(CarType carType) {
        int category = carType.getCategory();
        if (category < 1 || category > 7)
            throw new IllegalArgumentException("The category can not be lower than 1 or higher than 7!");
        return true;
    }
}
