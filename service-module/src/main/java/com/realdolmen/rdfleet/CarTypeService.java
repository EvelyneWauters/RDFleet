package com.realdolmen.rdfleet;

import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.repositories.CarTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by EWTAX45 on 30/10/2015.
 */
@Service
public class CarTypeService {
    @Autowired
    private CarTypeRepository carTypeRepository;


    public List<CarType> findAllAvailableCars()  {
        List<CarType> catalog = carTypeRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "category")));
        for (CarType carType : catalog) {
            if(carType.getIsAvailable() == false)  {
                catalog.remove(carType);
            }
        }
        return catalog;
    }

    public CarType findById(Long id)    {
        return carTypeRepository.findOne(id);
    }

    public void createOrUpdateCarType(CarType car)  {
        carTypeRepository.save(car);
    }

    //will not remove the CarType, but set the 'is available'-flag to false
    public void removeCarTypeFromList(Long id) {
        CarType carType = carTypeRepository.findOne(id);
        carType.setIsAvailable(false);
        if (carType != null) {
            createOrUpdateCarType(carType);
        }
    }
}
