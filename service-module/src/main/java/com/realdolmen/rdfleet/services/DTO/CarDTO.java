package com.realdolmen.rdfleet.services.DTO;

import com.realdolmen.rdfleet.converter.LocalDatePersistenceConverter;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.options.CarOption;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JDOAX80 on 5/11/2015.
 */
public class CarDTO extends AbstractDTO{

    @NotNull(message = "{field.errorMessage.isEmpty}")
    private CarType carType;
    @NotNull(message = "{field.errorMessage.isEmpty}")
    private String vinNumber;
    @NotNull(message = "{field.errorMessage.isEmpty}")
    private LocalDate startLeasing;
    private LocalDate endLeasing;
    private int leasingDurationYears = 4;
    private double mileage;
    private int amountOfRefuels;
    @NotNull(message = "{field.errorMessage.isEmpty}")
    private String numberPlate;
    private List<CarOption> carOptions = new ArrayList<>();
    private boolean inThePool;
    private boolean noLongerInUse;


    public CarDTO() {
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public LocalDate getStartLeasing() {
        return startLeasing;
    }

    public void setStartLeasing(LocalDate startLeasing) {
        this.startLeasing = startLeasing;
    }

    public LocalDate getEndLeasing() {
        return endLeasing;
    }

    public void setEndLeasing(LocalDate endLeasing) {
        this.endLeasing = endLeasing;
    }

    public int getLeasingDurationYears() {
        return leasingDurationYears;
    }

    public void setLeasingDurationYears(int leasingDurationYears) {
        this.leasingDurationYears = leasingDurationYears;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public int getAmountOfRefuels() {
        return amountOfRefuels;
    }

    public void setAmountOfRefuels(int amountOfRefuels) {
        this.amountOfRefuels = amountOfRefuels;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public List<CarOption> getCarOptions() {
        return carOptions;
    }

    public void setCarOptions(List<CarOption> carOptions) {
        this.carOptions = carOptions;
    }

    public boolean getInThePool() {
        return inThePool;
    }

    public void setInThePool(boolean inThePool) {
        this.inThePool = inThePool;
    }

    public boolean getNoLongerInUse() {
        return noLongerInUse;
    }

    public void setNoLongerInUse(boolean noLongerInUse) {
        this.noLongerInUse = noLongerInUse;
    }
}
