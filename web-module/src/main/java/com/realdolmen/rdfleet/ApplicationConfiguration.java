package com.realdolmen.rdfleet;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.options.CarOption;
import com.realdolmen.rdfleet.entities.car.options.CruiseControl;
import com.realdolmen.rdfleet.entities.car.options.HeatedSeats;
import com.realdolmen.rdfleet.entities.car.options.LeatherInterior;
import com.realdolmen.rdfleet.entities.car.options.enums.LeatherType;
import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.entities.employee.enums.Role;
import com.realdolmen.rdfleet.repositories.CarOptionRepository;
import com.realdolmen.rdfleet.repositories.CarRepository;
import com.realdolmen.rdfleet.repositories.EmployeeRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
public class ApplicationConfiguration {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ApplicationConfiguration.class).profiles("production").run(args);
        CarRepository carRepository = context.getBean(CarRepository.class);

//        CarType carType = new CarType();
//        carType.setIsAvailable(true);
//        Brand brand = new Brand();
//        brand.setName("BMW");
//        carType.setBrand(brand);
//        CarModel carModel = new CarModel();
//        carModel.setModelName("118");
//
//        Car carr = new Car();
//        carr.setMileage(888888);
//        carr.setAmountOfRefuels(70);
//        carr.setCarType(carType);
//        carRepository.save(carr);


        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        CarOptionRepository carOptionRepository = context.getBean(CarOptionRepository.class);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("password");
        Employee employee = new Employee("Foo", "Bar", "foo@bar.com", hashedPassword);
//        employee.setCurrentCar(carr);
        Employee fleetEmployee = new Employee("Floo", "Bar", "floo@bar.com", hashedPassword);

        CarOption option1 = new CruiseControl();
        CarOption option2 = new HeatedSeats();
        CarOption option3 = new LeatherInterior(LeatherType.IMITATION);
        fleetEmployee.setRole(Role.FLEET_EMPLOYEE);
        carOptionRepository.save(option1);
        carOptionRepository.save(option2);
        carOptionRepository.save(option3);
        employeeRepository.save(employee);
        employeeRepository.save(fleetEmployee);
    }
}

