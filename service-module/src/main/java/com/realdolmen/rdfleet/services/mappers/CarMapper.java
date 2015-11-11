package com.realdolmen.rdfleet.services.mappers;

import com.realdolmen.rdfleet.services.DTO.CarDTO;
import com.realdolmen.rdfleet.services.DTO.CarTypeDTO;
import com.realdolmen.rdfleet.entities.car.Car;

/**
 * Created by JDOAX80 on 6/11/2015.
 */
public class CarMapper {

    public static Car mapCarDTOToCarObject(CarDTO dto, Car car) {
        car.setId(dto.getId());
        car.setCarType(dto.getCarType());
        car.setVinNumber(dto.getVinNumber());
        car.setStartLeasing(dto.getStartLeasing());
        car.setMileage(dto.getMileage());
        car.setNumberPlate(dto.getNumberPlate());
        car.setAmountOfRefuels(dto.getAmountOfRefuels());
        car.setCarOptions(dto.getCarOptions());
        car.setInThePool(dto.getInThePool());
        car.setLeasingDurationYears(dto.getLeasingDurationYears());
        car.setNoLongerInUse(dto.getNoLongerInUse());

        return car;
    }


    public static CarDTO mapCarObjectToCarDTO(Car car) {
        CarDTO dto = new CarDTO();
        dto.setCarType(car.getCarType());
        dto.setAmountOfRefuels(car.getAmountOfRefuels());
        dto.setCarOptions(car.getCarOptions());
        dto.setEndLeasing(car.getEndLeasing());
        dto.setLeasingDurationYears(car.getLeasingDurationYears());
        dto.setMileage(car.getMileage());
        dto.setNumberPlate(car.getNumberPlate());
        dto.setStartLeasing(car.getStartLeasing());
        dto.setVinNumber(car.getVinNumber());
        return dto;
    }
}
