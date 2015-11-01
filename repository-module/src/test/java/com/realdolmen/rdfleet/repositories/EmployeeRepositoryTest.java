package com.realdolmen.rdfleet.repositories;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PersistenceException;

/**
 * Created by JDOAX80 on 30/10/2015.
 */
public class EmployeeRepositoryTest extends RepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void employeeCanBeCreated() {

    }

    @Test(expected = PersistenceException.class)
    public void employeeCantBeCreatedWithoutEmailAddress() {

    }

    @Test
    public void employeeCantBeCreatedWithoutPassword() {

    }

}
