package com.realdolmen.rdfleet;

import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.repositories.CarRepository;
import com.realdolmen.rdfleet.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by JDOAX80 on 4/11/2015.
 */
@Service
public class EmailJob {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CarRepository car;

    @Scheduled(cron="*/5 * * * * ")
    public void checkIfEmployeesCarLeaseIsNearlyExpiredAndSendEmailIfTrue() {
        List<Employee> employeesInNeedOfANewCar = getAllEmployeesWhoNeedANewCar();
        employeesInNeedOfANewCar.forEach(employee -> {
            //SEND AN EMAIL
        });
        employeesInNeedOfANewCar.forEach(employee ->  {
            employee.setMailForNewCarHasBeenSend(true);//field in employee voorzien die dit toelaat
        });
        employeeRepository.updateAllEmployees();

    }

    public List<Employee> getAllEmployeesWhoNeedANewCar() {
        return employeeRepository.findAllEmployeesWhereCarLeasePeriodIsAboutToExpire();//Methode aanmaken in employeerepository die op basis van date gaat querien.
    }


}

