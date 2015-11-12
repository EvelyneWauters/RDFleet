package com.realdolmen.rdfleet.services.DTO;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.employee.enums.Role;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by JDOAX80 on 28/10/2015.
 */
public class EmployeeDTO extends AbstractDTO implements Serializable{
    /**
     * Class fields
     */
    private String firstName;
    private String lastName;

    @Email
    @NotEmpty(message = "Please enter your email addresss.")
    private String email = "";

//    @NotEmpty
    private String password = "";

    @NotNull
    private Role role = Role.EMPLOYEE;

    @Min(value = 1, message = "functional level must be between 1 and 7")
    @Max(value = 7, message = "functional level must be between 1 and 7")
    private int functionalLevel = 1;

    private boolean active = true;

    private Car currentCar;
    private Set<Car> carHistory = new HashSet<>();
//    private Double monthlyCost;
//    private Double fines;

    /**
     * Getters & Setters
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getFunctionalLevel() {
        return functionalLevel;
    }

    public void setFunctionalLevel(int functionalLevel) {
        this.functionalLevel = functionalLevel;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

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

    public Set<Car> getCarHistory() {
        return carHistory;
    }

    public void setCarHistory(Set<Car> carHistory) {
        this.carHistory = carHistory;
    }
}
