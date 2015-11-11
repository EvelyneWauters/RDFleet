package com.realdolmen.rdfleet.services.definitions;

import com.realdolmen.rdfleet.services.DTO.CarTypeDTO;

import java.util.List;

/**
 * Created by JDOAX80 on 30/10/2015.
 */
public interface CarTypeService {

    CarTypeDTO findById(Long id);

    void createCarType(CarTypeDTO carTypeDTO);

    void updateExistingCarType(Long id, CarTypeDTO carTypeDTO);

    void removeCarTypeFromList(Long id);

    List<CarTypeDTO> findAllCarTypes();

    List<CarTypeDTO> findAllAvailableCarTypes();

    List<CarTypeDTO> findCarByFunctionalLevel(int i);

}
