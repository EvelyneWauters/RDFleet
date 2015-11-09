package com.realdolmen.rdfleet.services.implementations;

import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.repositories.CarRepository;
import com.realdolmen.rdfleet.repositories.CarTypeRepository;
import com.realdolmen.rdfleet.services.definitions.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    @Override
    public List<CarType> findAllCarTypes()  {
        return carTypeRepository.findAll();
    }


    @Override
    public List<CarType> findCarByFunctionalLevel(int i)    {
        return carTypeRepository.findCarTypeByCategory(i);
    }


    @Override
    public List<CarType> findAllAvailableCarTypes()  {
        List<CarType> catalog = carTypeRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "category")));
        for (Iterator<CarType> it = catalog.listIterator(); it.hasNext(); ) {
            CarType carType = it.next();
            if (carType.getIsAvailable() == false) {
                it.remove();
            }
        }
        return catalog;
    }


    @Override
    public CarType findById(Long id)    {
        CarType one = carTypeRepository.findOne(id);
        return one;
    }

    @Override
    public void createOrUpdateCarType(CarType car)  {
        carTypeRepository.save(car);
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
}
