package com.realdolmen.rdfleet.entities;

import javax.persistence.Entity;
import java.time.LocalDate;


@Entity
public class Car extends AbstractEntity{

    private String vinNumber;
    private LocalDate startLeasing;
    private int leasingDurationYears;

    private double mileage;
    private int amountOfRefuels;

    private boolean inThePool;
    private boolean noLongerInUse;

    public Car() {
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

    public boolean isInThePool() {
        return inThePool;
    }

    public void setInThePool(boolean inThePool) {
        this.inThePool = inThePool;
    }

    public boolean isNoLongerInUse() {
        return noLongerInUse;
    }

    public void setNoLongerInUse(boolean noLongerInUse) {
        this.noLongerInUse = noLongerInUse;
    }
}
