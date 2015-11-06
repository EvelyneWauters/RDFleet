package com.realdolmen.rdfleet.repositories;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import com.realdolmen.rdfleet.entities.employee.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

/**
 * Created by JDOAX80 on 30/10/2015.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class EmployeeRepositoryTest extends RepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @Test
    public void employeeCanBeCreated() {
        employee = new Employee();
        employee.setEmail("Bla@Bla.com");
        employee.setPasswordHash("zefzefé");
        employeeRepository.save(employee);
        assertNotNull(employee.getId());
    }

    @Test(expected = ConstraintViolationException.class)
    public void employeeCantBeCreatedWithoutEmailAddress() {
        employee = new Employee();
        employee.setPasswordHash("zefzefé");
        employeeRepository.save(employee);
    }

    @Test(expected = ConstraintViolationException.class)
    public void employeeCantBeCreatedWithoutPassword() {
        employee = new Employee();
        employee.setEmail("Bla@Bla.com");
        employeeRepository.save(employee);
    }


    @Test
    public void canFindAllEmployeesWhosCarLeaseIsAboutToExpire() {
        Employee employee = employeeRepository.findOne(1L);
        LocalDate date = employee.getCurrentCar().getEndLeasing();
        List<Employee> employees = employeeRepository.findAllEmployeesWhereCarLeasePeriodIsAboutToExpireAndWhereReceivedMailForNewCarIsFalse(date);
        assertEquals(1, employees.size());
    }

    @Test
    public void canFindAllEmployeesWhosCarLeaseIsAboutToExpireReturnsNoEmployeesWhenLowerThanEndLeasingDate() {
        Employee employee = employeeRepository.findOne(1L);
        LocalDate date = employee.getCurrentCar().getEndLeasing();
        date = date.minusMonths(1);
        List<Employee> employees = employeeRepository.findAllEmployeesWhereCarLeasePeriodIsAboutToExpireAndWhereReceivedMailForNewCarIsFalse(date);
        assertEquals(0, employees.size());
    }

    @Test
    public void canFindAllEmployeesWhosCarLeaseIsAboutToExpireReturnsNoEmployeesWhenReceivedEmailForNewCarIsTrue() {
        Employee employee = employeeRepository.findOne(1L);
        LocalDate date = employee.getCurrentCar().getEndLeasing();
        employee.setReceivedMailForNewCar(true);
        employeeRepository.save(employee);
        List<Employee> employees = employeeRepository.findAllEmployeesWhereCarLeasePeriodIsAboutToExpireAndWhereReceivedMailForNewCarIsFalse(date);
        assertEquals(0, employees.size());
    }

}
