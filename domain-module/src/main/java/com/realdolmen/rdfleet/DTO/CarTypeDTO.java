package com.realdolmen.rdfleet.DTO;

import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import com.realdolmen.rdfleet.entities.car.enums.FuelType;
import com.realdolmen.rdfleet.entities.car.enums.WinterTyresRimType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Embedded;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Created by JDOAX80 on 5/11/2015.
 */
public class CarTypeDTO extends AbstractDTO{

    @NotNull(message = "{field.errorMessage.isEmpty}")
    private Brand brand;
    @Valid
    private CarModelDTO carModelDTO;
    @Digits(integer = 10, fraction = 0, message = "{field.errorMessage.mustBeANumber}")
    @Min(value = 1, message = "{category.errorMessage.mustBeHigherThanOne}")
    @Max(value = 7, message = "{category.errorMessage.mustBeLowerThanSeven}")
    @NotNull(message = "{field.errorMessage.isEmpty}")
    private Integer category;
    @Digits(integer = 10, fraction = 0,  message = "{field.errorMessage.mustBeANumber}")
    @Min(value = 0, message = "{field.errorMessage.mustNotBeNegative}")
    @NotNull(message = "{field.errorMessage.isEmpty}")
    private Integer co2;
    @Digits(integer = 10, fraction = 0,  message = "{field.errorMessage.mustBeANumber}")
    @Min(value = 0, message = "{field.errorMessage.mustNotBeNegative}")
    @NotNull(message = "{field.errorMessage.isEmpty}")
    private Integer fiscHp;
    @NotNull(message = "{field.errorMessage.isEmpty}")
    private FuelType fuelType;
    @NotNull(message = "{field.errorMessage.isEmpty}")
    private WinterTyresRimType winterTyresRimType;
    @Digits(integer = 10, fraction = 0,  message = "{field.errorMessage.mustBeANumber}")
    @Min(value = 0, message = "{field.errorMessage.mustNotBeNegative}")
    @NotNull(message = "{field.errorMessage.isEmpty}")
    private Integer idealKm = 0;
    @Digits(integer = 10, fraction = 0,  message = "{field.errorMessage.mustBeANumber}")
    @Min(value = 0, message = "{field.errorMessage.mustNotBeNegative}")
    @NotNull(message = "{field.errorMessage.isEmpty}")
    private Integer maxKm = 0;
    @NotNull(message = "{field.errorMessage.isEmpty}")
    private Double benefitInKindPerMonth;
    @NotNull(message = "{field.errorMessage.isEmpty}")
    private Double amountUpgradeInclVat;
    @NotNull(message = "{field.errorMessage.isEmpty}")
    private Double amountDowngradeInclVat;
    @NotNull(message = "{field.errorMessage.isEmpty}")
    private Double listPriceInclRealVat;
    @NotNull
    private boolean isAvailable;


    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public CarModelDTO getCarModelDTO() {
        return carModelDTO;
    }

    public void setCarModelDTO(CarModelDTO carModelDTO) {
        this.carModelDTO = carModelDTO;
    }

    public Double getListPriceInclRealVat() {
        return listPriceInclRealVat;
    }

    public void setListPriceInclRealVat(Double listPriceInclRealVat) {
        this.listPriceInclRealVat = listPriceInclRealVat;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getCo2() {
        return co2;
    }

    public void setCo2(Integer co2) {
        this.co2 = co2;
    }

    public Integer getFiscHp() {
        return fiscHp;
    }

    public void setFiscHp(Integer fiscHp) {
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

    public Integer getIdealKm() {
        return idealKm;
    }

    public void setIdealKm(Integer idealKm) {
        this.idealKm = idealKm;
    }

    public Integer getMaxKm() {
        return maxKm;
    }

    public void setMaxKm(Integer maxKm) {
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

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
