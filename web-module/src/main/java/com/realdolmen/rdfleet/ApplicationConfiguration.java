package com.realdolmen.rdfleet;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.entities.employee.enums.Role;
import com.realdolmen.rdfleet.repositories.CarRepository;
import com.realdolmen.rdfleet.repositories.EmployeeRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class ApplicationConfiguration {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ApplicationConfiguration.class).profiles("production").run(args);
        CarRepository carRepository = context.getBean(CarRepository.class);
        Car car = new Car();
        car.setMileage(55000);
        car.setAmountOfRefuels(70);
        carRepository.save(car);

        Car carr = new Car();
        carr.setMileage(888888);
        carr.setAmountOfRefuels(70);
        carRepository.save(carr);

        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        Employee employee = new Employee("Foo", "Bar", "foo@bar.com", "password");
        employee.setCurrentCar(carr);
        Employee fleetEmployee = new Employee("Foo", "Bar", "floo@bar.com", "password");
        fleetEmployee.setRole(Role.FLEET_EMPLOYEE);
        employeeRepository.save(employee);
        employeeRepository.save(fleetEmployee);
    }
}

