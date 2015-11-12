package com.realdolmen.rdfleet;

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


@SpringBootApplication
public class ApplicationConfiguration {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ApplicationConfiguration.class).profiles("production").run(args);
    }
}

