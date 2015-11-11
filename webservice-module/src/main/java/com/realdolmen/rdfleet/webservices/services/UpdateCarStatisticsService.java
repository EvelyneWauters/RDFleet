package com.realdolmen.rdfleet.webservices.services;

import com.realdolmen.rdfleet.webservices.gen.Employees;
import com.realdolmen.rdfleet.webservices.gen.Success;
import com.realdolmen.rdfleet.webservices.gen.UpdateCarStatistics;
import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.webservices.repositories.CarRepositoryImpl;
import com.realdolmen.rdfleet.webservices.repositories.EmployeeRepositoryImpl;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by JDOAX80 on 10/11/2015.
 */
@Stateless
@WebService(wsdlLocation = "WEB-INF/wsdl/contract.wsdl", serviceName = "CarStatisticsService",
        targetNamespace = "http://realdolmen.com/", portName = "UpdateCarStatisticsServicePort")
public class UpdateCarStatisticsService implements UpdateCarStatistics {
    @Inject
    private EmployeeRepositoryImpl employeeRepository;

    @Inject
    private CarRepositoryImpl carRepository;

    @Override
    public Success updateCarStatistics(Employees parameters) {
        List<Employees.Employee> employees = parameters.getEmployee();
        System.out.println("Executing updateCarStatistics");
        Employee employee;
        Car car;
        for(Employees.Employee currEmployee : employees) {
            employee = employeeRepository.findEmployeeByEmail(currEmployee.getEmail());
            car = employee.getCurrentCar();
            car.setMileage(currEmployee.getCar().getMileage());
            car.setAmountOfRefuels(currEmployee.getCar().getAmountOfRefuels().intValue());
            carRepository.saveCar(car);
        }
        Success success = new Success();
        success.setResponseMessage("Success");
        return success;
    }
}
