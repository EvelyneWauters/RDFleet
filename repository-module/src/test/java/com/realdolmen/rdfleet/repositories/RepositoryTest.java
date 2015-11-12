package com.realdolmen.rdfleet.repositories;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.repositories.config.TestConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * Created by JDOAX80 on 30/10/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = TestConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class RepositoryTest extends Assert {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CarTypeRepository carTypeRepository;
    @Autowired
    private CarRepository carRepository;

    private CarType carType;
    private Car car;
    private Employee employee;

    @Before
    public void init() {
        carTypeRepository.save(createCarType());
        carRepository.save(createCar());
        employeeRepository.save(createEmployee());
    }

    public Car createCar() {
        car = new Car();
        car.setVinNumber("145214587e");
        car.setNumberPlate("1-JNL-745");
        car.setCarType(carType);
        car.setStartLeasing(LocalDate.now(ZoneId.systemDefault()));
        return car;
    }

    public CarType createCarType() {
        carType = new CarType();
        Brand brand = new Brand();
        brand.setName("Audi");
        CarModel model = new CarModel();
        model.setModelName("A1");
        carType.setCategory(1);
        carType.setBrand(brand);
        carType.setCarModel(model);
        return carType;
    }

    public Employee createEmployee() {
        employee = new Employee("Test", "Je", "test@rd.com", "passwordHash");
        employee.setCurrentCar(car);
        return employee;
    }

    public Employee getEmployee() {
        return employee;
    }
    public CarType getCarType() {
        return carType;
    }

    public Car getCar() {
        return car;
    }
}

