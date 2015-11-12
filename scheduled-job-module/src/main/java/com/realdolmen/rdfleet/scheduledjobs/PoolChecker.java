package com.realdolmen.rdfleet.scheduledjobs;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.repositories.CarRepository;
import com.realdolmen.rdfleet.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

/**
 * Created by JDOAX80 on 12/11/2015.
 */
@Component
public class PoolChecker {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Scheduled(cron = "0 0 0 * * * ")//runs every 24 hours at 12 o'clock PM
    public void removeCarFromPoolIfLeasingDurationHasPassed() {
        List<Employee> employees = employeeRepository.findAllCarsWhereLeasingHasRunToAnEnd(LocalDate.now(ZoneId.systemDefault()));
        employees.forEach(employee -> {
            employee.setCurrentCar(null);
        });
    }
}
