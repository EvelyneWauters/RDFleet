package com.realdolmen.rdfleet.DTO;

import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import com.realdolmen.rdfleet.entities.car.enums.FuelType;
import com.realdolmen.rdfleet.entities.car.enums.WinterTyresRimType;
import org.hibernate.validator.constraints.NotEmpty;

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
    @NotNull
    private Double listPriceInclRealVat;
    @Digits(integer = 10, fraction = 0, message = "This must be a number")
    @Min(value = 1, message = "Category must be higher or equal to 1")// {category.errorMessage.mustBeHigherThanOne}
    @Max(value = 7, message = "Category must be lower or equal to 7")// {category.errorMessage.mustBeLowerThanSeven}
    private int category;
    @Digits(integer = 10, fraction = 0)
    @Min(value = 0, message = "Value can't be negative")
    private int co2;
    @Digits(integer = 10, fraction = 0)
    @Min(value = 0, message = "Value can't be negative")
    private int fiscHp;
    @NotNull
    private FuelType fuelType;
    @NotNull
    private WinterTyresRimType winterTyresRimType;
    @Digits(integer = 10, fraction = 0)
    @Min(value = 0, message = "Value can't be negative")
    private int idealKm = 0;
    @Digits(integer = 10, fraction = 0)
    @Min(value = 0, message = "Value can't be negative")
    private int maxKm = 0;
    @NotNull
    private Double benefitInKindPerMonth;
    @NotNull
    private Double amountUpgradeInclVat;
    @NotNull
    private Double amountDowngradeInclVat;

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
