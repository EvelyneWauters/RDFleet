package com.realdolmen.rdfleet.entities;

import com.realdolmen.rdfleet.DTO.EmployeeDTO;
import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;
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
    /**
     * Class fields
     */
    private Employee employee;
    private CarType carType;


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
}
