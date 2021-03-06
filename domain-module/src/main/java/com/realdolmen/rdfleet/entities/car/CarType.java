package com.realdolmen.rdfleet.entities.car;

import com.realdolmen.rdfleet.entities.AbstractEntity;
import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import com.realdolmen.rdfleet.entities.car.enums.FuelType;
import com.realdolmen.rdfleet.entities.car.enums.WinterTyresRimType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by EWTAX45 on 28/10/2015.
 */

@Entity
public class CarType extends AbstractEntity implements Serializable{

    @Embedded
    private Brand brand;
    @Embedded
    private CarModel carModel;
    private Double listPriceInclRealVat;
    private int category;
    private int co2;
    @Column(name = "fiscHp")
    private int fiscHp = 0;
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;
    @Enumerated(EnumType.STRING)
    private WinterTyresRimType winterTyresRimType;
    @Column(name = "idealKm")
    private int idealKm = 0;
    @Column(name = "maxKm")
    private int maxKm = 0;
    private Double benefitInKindPerMonth;
    private Double amountUpgradeInclVat;
    private Double amountDowngradeInclVat;
    @Column(name = "isAvailable")
    private boolean isAvailable = true;

    /**
     * Constructors
     */
    public CarType() {
        //Used by Hibernate
    }

    /**
     * Getters & Setters
     */
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
        this.listPriceInclRealVat = Math.abs(listPriceInclRealVat);
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
        this.co2 = Math.abs(co2);
    }

    public int getFiscHp() {
        return fiscHp;
    }

    public void setFiscHp(int fiscHp) {
        this.fiscHp = Math.abs(fiscHp);
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
        this.idealKm = Math.abs(idealKm);
    }

    public int getMaxKm() {
        return maxKm;
    }

    public void setMaxKm(int maxKm) {
        this.maxKm = Math.abs(maxKm);
    }

    public Double getBenefitInKindPerMonth() {
        return benefitInKindPerMonth;
    }

    public void setBenefitInKindPerMonth(Double benefitInKindPerMonth) {
        this.benefitInKindPerMonth = Math.abs(benefitInKindPerMonth);
    }

    public Double getAmountUpgradeInclVat() {
        return amountUpgradeInclVat;
    }

    public void setAmountUpgradeInclVat(Double amountUpgradeInclVat) {
        this.amountUpgradeInclVat = Math.abs(amountUpgradeInclVat);
    }

    public Double getAmountDowngradeInclVat() {
        return amountDowngradeInclVat;
    }

    public void setAmountDowngradeInclVat(Double amountDowngradeInclVat) {
        this.amountDowngradeInclVat = Math.abs(amountDowngradeInclVat);
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
