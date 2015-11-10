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
public class Car extends AbstractEntity{
    /**
     * Class fields
     */
    @ManyToOne(optional = false)
    //-->2 in 1: Zowel Column(nullable = false, als validatie mbv JSR303)--> ligt wel aan het feit dat Hibernate de default JPA implementatie is
    //Niet elke JPA implementatie dient JSR 303 te ondersteunen en zal dit dus voor werken.
    private CarType carType;
    @Column(name = "vinNumber", unique = true, nullable = false)
    private String vinNumber;
    @Convert(converter= LocalDatePersistenceConverter.class)
    @Column(name = "startLeasing", nullable = false)
    private LocalDate startLeasing;
    @Convert(converter= LocalDatePersistenceConverter.class)
    private LocalDate endLeasing;
    @Column(name = "leasingDurationYears")
    private int leasingDurationYears = 4;
    @Column(name = "mileage")
    private double mileage = 0;
    @Column(name = "amountOfRefuels")
    private int amountOfRefuels = 0;
    @Column(name = "noLongerInUse")
    private boolean noLongerInUse = false;
    @Column(nullable = false)
    private String numberPlate;
    @ManyToMany (fetch = FetchType.EAGER)
    private List<CarOption> carOptions = new ArrayList<>();
    @Column(name="inThePool")
    private boolean inThePool = false;


    /**
     * Constructor
     */
    public Car() {
        //Used by Hibernate
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
        setEndLeasing();
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

    public List<CarOption> getCarOptions() {
        return carOptions;
    }

    public void setCarOptions(List<CarOption> carOptions) {
        this.carOptions = carOptions;
    }

    public LocalDate getEndLeasing() {
        return endLeasing;
    }

    public void setEndLeasing() {
        this.endLeasing = startLeasing.plusYears(leasingDurationYears);
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public boolean getInThePool() {
        return inThePool;
    }

    public void setInThePool(boolean inThePool) {
        inThePool = inThePool;
    }
}
