package com.realdolmen.rdfleet.repositories;

import com.realdolmen.rdfleet.entities.employee.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

/**
 * Created by JDOAX80 on 30/10/2015.
 */
public class EmployeeRepositoryTest extends RepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @Before
    public void init() {
        employee = new Employee();
    }

    @Test
    public void employeeCanBeCreated() {
        employee.setEmail("Bla@Bla.com");
        employee.setPasswordHash("zefzefé");
        employeeRepository.save(employee);
    }

    @Test(expected = ConstraintViolationException.class)
    public void employeeCantBeCreatedWithoutEmailAddress() {
        employee.setPasswordHash("zefzefé");
        employeeRepository.save(employee);
    }

    @Test(expected = ConstraintViolationException.class)
    public void employeeCantBeCreatedWithoutPassword() {
        employee.setEmail("Bla@Bla.com");
        employeeRepository.save(employee);
    }

}
