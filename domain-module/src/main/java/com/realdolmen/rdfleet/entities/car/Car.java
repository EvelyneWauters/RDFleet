package com.realdolmen.rdfleet.entities.car;

import com.realdolmen.rdfleet.entities.AbstractEntity;

import javax.persistence.Entity;
import java.time.LocalDate;


@Entity
public class Car extends AbstractEntity{
    /**
     * Class fields
     */

    @ManyToOne
    private CarType carType;

    //vinNumber is unique for each car
    private String vinNumber;
    private LocalDate startLeasing;
    //default value = 4 years (set in data.sql)
    private int leasingDurationYears;

    //default value = 0 (set in data.sql)
    private double mileage;
    //default value = 0 (set in data.sql)
    private int amountOfRefuels;

    private boolean noLongerInUse;



    /**
     * Constructor
     */

    public Car() {
    }


    /**
     * Bussiness Methods
     */


    /**
     * Getters & Setters
     */

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

    public boolean isNoLongerInUse() {
        return noLongerInUse;
    }

    public void setNoLongerInUse(boolean noLongerInUse) {
        this.noLongerInUse = noLongerInUse;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}
