package com.realdolmen.rdfleet.entities.car;

import com.realdolmen.rdfleet.converter.LocalDatePersistenceConverter;
import com.realdolmen.rdfleet.entities.AbstractEntity;
import com.realdolmen.rdfleet.entities.car.options.CarOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Car extends CarComponent { //AbstractEntity{
    /**
     * Class fields
     */

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    @NotNull
    private CarType carType;
    @Column(name = "vinNumber", unique = true)
    private String vinNumber;
    @Convert(converter= LocalDatePersistenceConverter.class)
    private LocalDate startLeasing;
    @Column(name = "leasingDurationYears")
    private int leasingDurationYears = 4;
    @Column(name = "mileage")
    private double mileage = 0;
    @Column(name = "amountOfRefuels")
    private int amountOfRefuels = 0;
    @Column(name = "noLongerInUse")
    private boolean noLongerInUse = false;


    private List<CarOption> options = new ArrayList<>();

    /**
     * Constructor
     */
    public Car() {
    }

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
        this.leasingDurationYears = Math.abs(leasingDurationYears);
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = Math.abs(mileage);
    }

    public int getAmountOfRefuels() {
        return amountOfRefuels;
    }

    public void setAmountOfRefuels(int amountOfRefuels) {
        this.amountOfRefuels = Math.abs(amountOfRefuels);
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

    @Override
    public double cost() {
        return 0;
    }
}
