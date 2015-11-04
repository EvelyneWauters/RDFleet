package com.realdolmen.rdfleet.entities;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.employee.Employee;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * Created by JDOAX80 on 4/11/2015.
 */
@Entity
public class Order extends AbstractEntity {

    @OneToOne(optional = false)
    @JoinColumn(unique = true)
    @NotNull
    private Employee employee;

    @NotNull
    private Car car;

    public Order() {
    }

    public Order(Employee employee, Car car) {
        this.employee = employee;
        this.car = car;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
