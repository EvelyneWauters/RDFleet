package com.realdolmen.rdfleet.services.mappers;

import com.realdolmen.rdfleet.DTO.CarDTO;
import com.realdolmen.rdfleet.DTO.CarTypeDTO;
import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;

/**
 * Created by JDOAX80 on 6/11/2015.
 */
public class CarMapper {

    public static Car mapCarTypeDTOToCarTypeObject(CarDTO dto, Car car) {
        return car;
    }


    public static CarDTO mapCarTypeObjectToCarTypeDTO(Car car) {
        CarDTO dto = new CarDTO();

        return dto;
    }
}
