package com.realdolmen.rdfleet.entities.car;

import com.realdolmen.rdfleet.entities.AbstractEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;

/**
 * Created by EWTAX45 on 28/10/2015.
 */

@Entity
public class CarType extends AbstractEntity {
    @Embedded
    private Brand brand;
    @Embedded
    private CarModel carModel;

    //List price Incl. real VAT
    private Double listPriceInclRealVat;


    private int category;
    private int co2;
    private int fiscHp;
    private FuelType fuelType;

    private WinterTyresRimType winterTyresRimType;

    //IDEAL KM according to type of car
    private int idealKm;
    //max. KM or 60 months on request of driver
    private int maxKm;

    private Double benefitInKindPerMonth;
    private Double amountUpgradeInclVat;
    private Double amountDowngradeInclVat;


    public CarType() {
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
