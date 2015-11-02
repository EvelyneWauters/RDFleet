package com.realdolmen.rdfleet.entities;

import com.realdolmen.rdfleet.entities.employee.Employee;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;

/**
 * Created by JDOAX80 on 30/10/2015.
 */
public class EmployeeEntityTest extends Assert {

    @Test(expected = IllegalArgumentException.class)
    public void employeeFunctionalLevelCantBeLowerThanOne() {
        Employee employee = new Employee();
        employee.setFunctionalLevel(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void employeeFunctionalLevelCantBeHigherThanSeven() {
        Employee employee = new Employee();
        employee.setFunctionalLevel(8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void employeeFunctionalLevelCantBeNegative() {
        Employee employee = new Employee();
        employee.setFunctionalLevel(-1);
    }
}
