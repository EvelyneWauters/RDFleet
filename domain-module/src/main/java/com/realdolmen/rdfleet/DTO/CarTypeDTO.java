package com.realdolmen.rdfleet.DTO;

import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import com.realdolmen.rdfleet.entities.car.enums.FuelType;
import com.realdolmen.rdfleet.entities.car.enums.WinterTyresRimType;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by JDOAX80 on 5/11/2015.
 */
public class CarTypeDTO implements Serializable {
    private Long id;
    private Brand brand;
    private CarModel carModel;
    private Double listPriceInclRealVat;
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


    public CarTypeDTO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public Double getListPriceInclRealVat() {
        return listPriceInclRealVat;
    }

    public void setListPriceInclRealVat(Double listPriceInclRealVat) {
        this.listPriceInclRealVat = listPriceInclRealVat;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getCo2() {
        return co2;
    }

    public void setCo2(int co2) {
        this.co2 = co2;
    }

    public int getFiscHp() {
        return fiscHp;
    }

    public void setFiscHp(int fiscHp) {
        this.fiscHp = fiscHp;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public WinterTyresRimType getWinterTyresRimType() {
        return winterTyresRimType;
    }

    public void setWinterTyresRimType(WinterTyresRimType winterTyresRimType) {
        this.winterTyresRimType = winterTyresRimType;
    }

    public int getIdealKm() {
        return idealKm;
    }

    public void setIdealKm(int idealKm) {
        this.idealKm = idealKm;
    }

    public int getMaxKm() {
        return maxKm;
    }

    public void setMaxKm(int maxKm) {
        this.maxKm = maxKm;
    }

    public Double getBenefitInKindPerMonth() {
        return benefitInKindPerMonth;
    }

    public void setBenefitInKindPerMonth(Double benefitInKindPerMonth) {
        this.benefitInKindPerMonth = benefitInKindPerMonth;
    }

    public Double getAmountUpgradeInclVat() {
        return amountUpgradeInclVat;
    }

    public void setAmountUpgradeInclVat(Double amountUpgradeInclVat) {
        this.amountUpgradeInclVat = amountUpgradeInclVat;
    }

    public Double getAmountDowngradeInclVat() {
        return amountDowngradeInclVat;
    }

    public void setAmountDowngradeInclVat(Double amountDowngradeInclVat) {
        this.amountDowngradeInclVat = amountDowngradeInclVat;
    }
}
