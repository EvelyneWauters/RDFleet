package com.realdolmen.rdfleet.services.definitions;

import com.realdolmen.rdfleet.DTO.CarTypeDTO;
import com.realdolmen.rdfleet.entities.car.CarType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by JDOAX80 on 30/10/2015.
 */
public interface CarTypeService {
//    List<CarType> findAllCarTypes();
//
//    List<CarType> findAllAvailableCarTypes();
//
//    List<CarType> findCarByFunctionalLevel(int i);

    CarTypeDTO findById(Long id);

    void createCarType(CarTypeDTO carTypeDTO);

    void updateExistingCarType(Long id, CarTypeDTO carTypeDTO);

    void removeCarTypeFromList(Long id);

    List<CarTypeDTO> findAllCarTypes();

    List<CarTypeDTO> findAllAvailableCarTypes();

    List<CarTypeDTO> findCarByFunctionalLevel(int i);

}
