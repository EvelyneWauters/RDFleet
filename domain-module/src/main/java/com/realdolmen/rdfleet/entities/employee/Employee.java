package com.realdolmen.rdfleet.entities.employee;

import com.realdolmen.rdfleet.entities.employee.enums.Role;
import com.realdolmen.rdfleet.entities.car.Car;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee extends User {
    /**
     * Class fields
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    private Car currentCar;

//    @ManyToMany
    @ElementCollection
    private Set<Car> carList = new HashSet<>();
    @Column(name="functionalLevel")
    private int functionalLevel = 1;
    private Double monthlyCost;
    private Double fines;

    @Column(name="active")
    private boolean active = true;


    /**
     * Constructor
     */

    public Employee() {

    }

    public Employee(String firstName, String lastName, String email, String passwordHash)
    {
        super(firstName, lastName, email, passwordHash);
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
        if(functionalLevel >= 1 && functionalLevel <= 7) {
            this.functionalLevel = functionalLevel;
        }
        else {
            throw new IllegalArgumentException("The functional level can not be lower than 1 or higher than 7!");
        }
    }

    public Double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(Double monthlyCost) {
        this.monthlyCost = Math.abs(monthlyCost);
    }

    public Double getFines() {
        return fines;
    }

    public void setFines(Double fines) {
        this.fines = Math.abs(fines);
    }

    public Set<Car> getCarList() {
        return carList;
    }

    public void setCarList(Set<Car> carList) {
        this.carList = carList;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
