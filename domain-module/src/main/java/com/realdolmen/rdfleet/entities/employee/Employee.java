package com.realdolmen.rdfleet.entities.employee;

import com.realdolmen.rdfleet.entities.employee.enums.Role;
import com.realdolmen.rdfleet.entities.car.Car;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee extends User implements Serializable {
    /**
     * Class fields
     */
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(unique = true)
    private Car currentCar;
    @ManyToMany (fetch = FetchType.EAGER)
    private Set<Car> carHistory = new HashSet<>();
    @Column(name = "functionalLevel")
    private int functionalLevel = 1;
    private Double monthlyCost;
    private Double fines;
    @Column(name = "active")
    private boolean active = true;
    @Column(name = "receivedMailForNewCar")
    private boolean receivedMailForNewCar = false;


    /**
     * Constructors
     */
    public Employee() {
        //Used by Hibernate
    }

    public Employee(String firstName, String lastName, String email, String passwordHash)
    {
        super(firstName, lastName, email, passwordHash);
    }

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
        this.monthlyCost = Math.abs(monthlyCost);
    }

    public Double getFines() {
        return fines;
    }

    public void setFines(Double fines) {
        this.fines = Math.abs(fines);
    }

    public Set<Car> getCarHistory() {
        return carHistory;
    }

    public void setCarHistory(Set<Car> carHistory) {
        this.carHistory = carHistory;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getReceivedMailForNewCar() {
        return receivedMailForNewCar;
    }

    public void setReceivedMailForNewCar(boolean receivedMailForNewCar) {
        this.receivedMailForNewCar = receivedMailForNewCar;
    }
}
