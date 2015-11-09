package com.realdolmen.rdfleet.services.mappers;

import com.realdolmen.rdfleet.DTO.CarModelDTO;
import com.realdolmen.rdfleet.DTO.CarTypeDTO;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;

/**
 * Created by JDOAX80 on 6/11/2015.
 */
public class CarTypeMapper {

    public static CarType mapCarTypeDTOToCarTypeObject(CarTypeDTO dto, CarType carType) {
        carType.setId(dto.getId());
        carType.setCategory(dto.getCategory());
        carType.setCarModel(dto.getCarModel());
        carType.setBrand(dto.getBrand());
        carType.setFiscHp(dto.getFiscHp());
        carType.setCo2(dto.getCo2());
        carType.setAmountDowngradeInclVat(dto.getAmountDowngradeInclVat());
        carType.setAmountUpgradeInclVat(dto.getAmountUpgradeInclVat());
        carType.setBenefitInKindPerMonth(dto.getBenefitInKindPerMonth());
        carType.setIdealKm(dto.getIdealKm());
        carType.setMaxKm(dto.getMaxKm());
        carType.setFuelType(dto.getFuelType());
        carType.setWinterTyresRimType(dto.getWinterTyresRimType());
        carType.setListPriceInclRealVat(dto.getListPriceInclRealVat());
        carType.setIsAvailable(carType.getIsAvailable());
        carType.getCarModel().setModelName(dto.getModelName());
        carType.getCarModel().setImageUrl(dto.getImageUrl());
        carType.getCarModel().setHorsePower(dto.getHorsePower());
        return carType;
    }

//    private static CarModel mapCarModelDTOToCarModelObject(CarModelDTO carModelDTO, CarModel carModel) {
//        carModel.setModelName(carModelDTO.getModelName());
//        carModel.setImageUrl(carModelDTO.getImageUrl());
//        carModel.setHorsePower(carModelDTO.getHorsePower());
//        carModel.setModelDesignation(carModelDTO.getModelDesignation());
//        carModel.setVersionName(carModelDTO.getVersionName());
//        return carModel;
//    }

//    private static CarModelDTO mapCarModelToCarModelDTO(CarModel carModel) {
//        CarModelDTO carModelDTO = new CarModelDTO();
//        carModelDTO.setModelName(carModel.getModelName());
//        carModelDTO.setImageUrl(carModel.getImageUrl());
//        carModelDTO.setHorsePower(carModel.getHorsePower());
//        carModelDTO.setModelDesignation(carModel.getModelDesignation());
//        carModel.setVersionName(carModel.getVersionName());
//        return carModelDTO;
//    }

    public static CarTypeDTO mapCarTypeObjectToCarTypeDTO(CarType carType) {
        CarTypeDTO dto = new CarTypeDTO();
        dto.setId(carType.getId());
        dto.setCategory(carType.getCategory());
        dto.setCarModel(carType.getCarModel());
        dto.setBrand(carType.getBrand());
        dto.setFiscHp(carType.getFiscHp());
        dto.setCo2(carType.getCo2());
        dto.setAmountDowngradeInclVat(carType.getAmountDowngradeInclVat());
        dto.setAmountUpgradeInclVat(carType.getAmountUpgradeInclVat());
        dto.setBenefitInKindPerMonth(carType.getBenefitInKindPerMonth());
        dto.setIdealKm(carType.getIdealKm());
        dto.setMaxKm(carType.getMaxKm());
        dto.setFuelType(carType.getFuelType());
        dto.setWinterTyresRimType(carType.getWinterTyresRimType());
        dto.setIsAvailable(carType.getIsAvailable());
        dto.setListPriceInclRealVat(carType.getListPriceInclRealVat());
        return dto;
    }
}
