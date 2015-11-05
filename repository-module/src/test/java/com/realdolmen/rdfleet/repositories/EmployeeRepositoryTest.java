package com.realdolmen.rdfleet.repositories;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import com.realdolmen.rdfleet.entities.employee.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

/**
 * Created by JDOAX80 on 30/10/2015.
 */
public class EmployeeRepositoryTest extends RepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;
    private Car car;

    @Before
    public void init() {
        car = new Car();
        CarType carType = new CarType();
        CarModel carModel = new CarModel();
        carModel.setModelName("A6");
        Brand brand = new Brand();
        brand.setName("Audi");
        carType.setBrand(brand);
        carType.setCarModel(carModel);
        carType.setCategory(1);
        car.setCarType(carType);
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


    @Test
    public void canFindAllEmployeesWhosCarLeaseIsAboutToExpire() {
        LocalDate date = LocalDate.now(ZoneId.systemDefault());
        date = date.plusYears(4);
        car.setStartLeasing(LocalDate.now());
        car.setEndLeasing();
        employee.setCurrentCar(car);
        employeeRepository.save(employee);
        List<Employee> employees = employeeRepository.findAllEmployeesWhereCarLeasePeriodIsAboutToExpireAndWhereReceivedMailForNewCarIsFalse(date);
        assertEquals(1, employees.size());
    }

    @Test
    public void canFindAllEmployeesWhosCarLeaseIsAboutToExpireReturnsNoEmployees() {
        LocalDate date = LocalDate.now(ZoneId.systemDefault());
        date = date.plusMonths(5);
        car.setStartLeasing(LocalDate.now());
        car.setEndLeasing();
        List<Employee> employees = employeeRepository.findAllEmployeesWhereCarLeasePeriodIsAboutToExpireAndWhereReceivedMailForNewCarIsFalse(date);
        assertEquals(0, employees.size());
    }

    @Test
    public void canFindAllEmployeesWhosCarLeaseIsAboutToExpireReturnsNoEmployeesWhenReceivedEmailForNewCarIsTrue() {
        LocalDate date = LocalDate.now(ZoneId.systemDefault());
        date = date.plusYears(4);
        car.setStartLeasing(LocalDate.now());
        car.setEndLeasing();
        employee.setReceivedMailForNewCar(true);
        List<Employee> employees = employeeRepository.findAllEmployeesWhereCarLeasePeriodIsAboutToExpireAndWhereReceivedMailForNewCarIsFalse(date);
        assertEquals(0, employees.size());
    }
}
