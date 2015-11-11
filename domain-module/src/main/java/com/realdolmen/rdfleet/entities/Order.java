package com.realdolmen.rdfleet.entities;

import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.options.CarOption;
import com.realdolmen.rdfleet.entities.employee.Employee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JDOAX80 on 4/11/2015.
 */
@Entity
@Table(name = "CarOrder")
public class Order extends AbstractEntity {
    /**
     * Class fields
     */
    @OneToOne(optional = false)
    @JoinColumn(unique = true)
    private Employee employee;
    @ManyToOne
    private CarType carType;
    @ManyToMany
    private List<CarOption> options = new ArrayList<>();

    /**
     * Constructors
     */
    public Order() {
        //Used by Hibernate
    }

    public Order(CarType carType, Employee employee) {
        this.carType = carType;
        this.employee = employee;
    }

    /**
     * Getters & Setters
     */
    public Order(Employee employee, CarType carType) {
        this.employee = employee;
        this.carType = carType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public List<CarOption> getOptions() {
        return options;
    }

    public void setOptions(List<CarOption> options) {
        this.options = options;
    }


}
