package com.realdolmen.rdfleet;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.Employee;
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
        Employee employee = new Employee("foobar", "password");
        employee.setCurrentCar(carr);
        employee.setFirstName("foo");
        employee.setLastName("barrr");
        employeeRepository.save(employee);
    }
}

