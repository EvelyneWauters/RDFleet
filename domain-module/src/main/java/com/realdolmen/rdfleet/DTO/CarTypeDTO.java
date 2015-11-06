package com.realdolmen.rdfleet.DTO;

import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import com.realdolmen.rdfleet.entities.car.enums.FuelType;
import com.realdolmen.rdfleet.entities.car.enums.WinterTyresRimType;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by JDOAX80 on 5/11/2015.
 */
public class CarTypeDTO {
    @NotNull
    private Brand brand;
    @NotNull
    private CarModel carModel;
    //List price Incl. real VAT
    private Double listPriceInclRealVat;
    @Digits(integer=10, fraction=0)
    @Min(value = 1, message = "Category must be higher or equal to 1")
    @Max(value = 7, message = "Category must be lower or equal to 7")
    private int category;
    private int co2;
    private int fiscHp;
    private FuelType fuelType;
    private WinterTyresRimType winterTyresRimType;
    private int idealKm;
    private int maxKm;
    private Double benefitInKindPerMonth;
    private Double amountUpgradeInclVat;
    private Double amountDowngradeInclVat;
}
