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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Created by EWTAX45 on 30/10/2015.
 */
@Service
public class CarTypeServiceImpl implements CarTypeService {

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
    public List<CarTypeDTO> findAllCarTypes() {
        List<CarType> allCarTypes = carTypeRepository.findAll();
        return mapEntityListToDTOList(allCarTypes);
    }


    @Override
    public List<CarTypeDTO> findCarByFunctionalLevel(int i) {
        List<CarType> allCarTypes = carTypeRepository.findCarTypeByCategory(i);
        return mapEntityListToDTOList(allCarTypes);
    }


    @Override
    public List<CarTypeDTO> findAllAvailableCarTypes() {
        List<CarType> allCarTypes = carTypeRepository.findAllByIsAvailableTrue();
        return mapEntityListToDTOList(allCarTypes);
    }

    public List<CarTypeDTO> mapEntityListToDTOList(List<CarType> carTypes) {
        List<CarTypeDTO> allCarTypeDTOs = new ArrayList<>();
        carTypes.forEach(carType -> {
            allCarTypeDTOs.add(CarTypeMapper.mapCarTypeObjectToCarTypeDTO(carType));
        });
        return allCarTypeDTOs;
    }

    @Override
    public CarTypeDTO findById(Long id) {
        return CarTypeMapper.mapCarTypeObjectToCarTypeDTO(carTypeRepository.findOne(id));
    }

    @Override
//    @Transactional(readOnly = false)
    public void createCarType(CarTypeDTO carTypeDTO) {
        CarType carType = new CarType();
        carType = CarTypeMapper.mapCarTypeDTOToCarTypeObject(carTypeDTO, carType);
        checkIfValidEntity(carType);
        carTypeRepository.save(carType);
    }


    @Override
//    @Transactional(readOnly = false)
    public void updateExistingCarType(Long id, CarTypeDTO carTypeDTO) {
        Optional<CarType> carTypeForGivenId = Optional.ofNullable(carTypeRepository.findOne(id));
        if (carTypeForGivenId.isPresent()) {
            CarType editedCarType = CarTypeMapper.mapCarTypeDTOToCarTypeObject(carTypeDTO, carTypeRepository.findOne(id));//The edited carType
            carTypeRepository.save(editedCarType);
        } else {
            throw new IllegalArgumentException("there is no cartype found with id " + id);
        }

    }

    //will not remove the CarType, but set the 'is available'-flag to false
    @Override
//    @Transactional(readOnly = false)
    public void removeCarTypeFromList(Long id) {
        CarType carType = carTypeRepository.findOne(id);
        carType.setIsAvailable(false);
        if (carType != null) {
            carTypeRepository.save(carType);
        }
    }

    public boolean checkIfValidEntity(CarType carType) {
        int category = carType.getCategory();
        if (category < 1 || category > 7)
            throw new IllegalArgumentException("The category can not be lower than 1 or higher than 7!");
        return true;
    }
}
