package com.realdolmen.rdfleet.repositories;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import com.realdolmen.rdfleet.entities.employee.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.PersistenceException;
import javax.validation .ConstraintViolationException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created by JDOAX80 on 30/10/2015.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class EmployeeRepositoryTest extends RepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CarRepository carRepository;

    private Employee employee;

    @Before
    public void init() {
        super.init();
        employee = new Employee();
        employee.setEmail("Bla@Bla.com");
        employee.setPasswordHash("zefzefé");
    }

    @Test
    public void employeeCanBeCreated() {
        employeeRepository.save(employee);
        assertNotNull(employee.getId());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void currentCarAssignedToAnEmployeeMustBeUnique() {
        employee.setCurrentCar(getCar());
        employeeRepository.save(this.employee);
    }

    @Test
    public void findOneByEmailCanBeSuccessfullyCalled() {
        employeeRepository.save(employee);
        Employee fetchedEmployee = employeeRepository.findOneByEmail("Bla@Bla.com").get();
        assertNotNull(fetchedEmployee.getId());
    }

    @Test(expected = NoSuchElementException.class)//throwt deze error wanneer je werkt met een optional die niets bevat
    public void findOneByEmailReturnsNoEmployeesForNonExistingEmailAddress() {
        employeeRepository.save(employee);
        employeeRepository.findOneByEmail("Bli@Bla.com").get();
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

    @Test
    public void canFindAllCarsWhereLeasingHasRunToAnEnd() {
        Car car = getCar();
        LocalDate fourYearsAgo = LocalDate.now();
        fourYearsAgo = fourYearsAgo.minusYears(4);
        car.setStartLeasing(fourYearsAgo);
        car.setLeasingDurationYears(4);//end leasing is thus set on today
        carRepository.save(car);
        List<Employee> employees = employeeRepository.findAllCarsWhereLeasingHasRunToAnEnd(LocalDate.now());
        assertEquals(1, employees.size());
    }

    @Test
    public void findAllCarsWhereLeasingHasRunToAnEndReturnsNoCarsWhenLeasingHasNotRunToAnEnd() {
        Car car = getCar();
        LocalDate fourYearsAgo = LocalDate.now();
        fourYearsAgo = fourYearsAgo.minusYears(6);
        car.setStartLeasing(fourYearsAgo);
        car.setLeasingDurationYears(4);//end leasing is thus set on a year from now
        carRepository.save(car);
        List<Employee> employees = employeeRepository.findAllCarsWhereLeasingHasRunToAnEnd(LocalDate.now());
        assertEquals(0, employees.size());
    }

    @Test
    public void canFindAllByActive() {
        List<Employee> employees = employeeRepository.findAllByActive(true);
        assertEquals(1, employees.size());
    }

    @Test
    public void canFindAllByActiveReturnsNoEmployeesWhenNoneAreActive() {
        List<Employee> employees = employeeRepository.findAllByActive(false);
        assertEquals(0, employees.size());
    }
}
