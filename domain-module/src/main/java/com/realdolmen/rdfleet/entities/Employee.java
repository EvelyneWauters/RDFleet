package com.realdolmen.rdfleet.entities;

import com.realdolmen.rdfleet.entities.car.Car;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee extends Person{
    /**
     * Class fields
     */
    @OneToOne
    private Car currentCar;

    @ManyToMany
    private Set<Car> carList = new HashSet<>();
    private int functionalLevel;
    private Double monthlyCost;
    private Double fines;


    /**
     * Constructor
     */

    public Employee(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Employee() {
        super("","");
    }


    /**
     * Bussiness Methods
     */


    /**
     * Getters & Setters
     */
    public Car getCurrentCar() {
        return currentCar;
    }

    public void setCurrentCar(Car currentCar) {
        this.currentCar = currentCar;
    }

    public int getFunctionalLevel() {
        return functionalLevel;
    }

    public void setFunctionalLevel(int functionalLevel) {
        this.functionalLevel = functionalLevel;
    }

    public Double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(Double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public Double getFines() {
        return fines;
    }

    public void setFines(Double fines) {
        this.fines = fines;
    }
}
