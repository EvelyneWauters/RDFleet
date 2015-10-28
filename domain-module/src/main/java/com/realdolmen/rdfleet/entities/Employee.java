package com.realdolmen.rdfleet.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Employee extends User{
    /**
     * Class fields
     */
    private String firstName;
    private String lastName;
    @OneToOne
    private Car currentCar;
    private int functionalLevel;
    private Double monthlyCost;
    private Double fines;



    /**
     * Constructor
     */

    public Employee(String username, String password) {
        super(username, password);
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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
