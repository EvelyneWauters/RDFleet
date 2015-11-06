package com.realdolmen.rdfleet.services.mappers;

import com.realdolmen.rdfleet.DTO.CarTypeDTO;
import com.realdolmen.rdfleet.entities.car.CarType;

/**
 * Created by JDOAX80 on 6/11/2015.
 */
public class CarTypeMapper {

    public static CarType mapCarTypeDTOToCarTypeObject(CarTypeDTO dto, CarType carType) {
        return carType;
    }


    public static CarTypeDTO mapCarTypeObjectToCarTypeDTO(CarType carType) {
        CarTypeDTO dto = new CarTypeDTO();

        return dto;
    }
}
