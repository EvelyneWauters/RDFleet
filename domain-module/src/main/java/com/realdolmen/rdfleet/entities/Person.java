package com.realdolmen.rdfleet.entities;

import javax.persistence.MappedSuperclass;

/**
 * Created by JDOAX80 on 28/10/2015.
 */
@MappedSuperclass
public class Person extends AbstractEntity {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
