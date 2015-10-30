package com.realdolmen.rdfleet.entities.employee;

import com.realdolmen.rdfleet.entities.employee.enums.Role;
import com.realdolmen.rdfleet.entities.AbstractEntity;

import javax.persistence.*;

@MappedSuperclass
public class User extends AbstractEntity {

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role = Role.EMPLOYEE;

    private String firstName;
    private String lastName;

    public User() {
        //Used by Hibernate
    }

    public User(String firstName, String lastName, String email, String passwordHash) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
}



