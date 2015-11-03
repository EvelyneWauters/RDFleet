package com.realdolmen.rdfleet.DTO;

import com.realdolmen.rdfleet.entities.employee.enums.Role;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by JDOAX80 on 28/10/2015.
 */
public class EmployeeDTO {
    /**
     * Class fields
     */
    @NotEmpty
    @Email
    private String email = "";

    @NotEmpty
    private String password = "";

    @NotNull
    private Role role = Role.EMPLOYEE;

    @Min(value = 1, message = "functional level must be between 1 and 7")
    @Max(value = 7, message = "functional level must be between 1 and 7")
    private int functionalLevel = 1;




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
}
