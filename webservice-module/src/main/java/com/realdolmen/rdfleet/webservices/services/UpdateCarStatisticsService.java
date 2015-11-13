package com.realdolmen.rdfleet.webservices.services;

import com.realdolmen.rdfleet.webservices.gen.Employees;
import com.realdolmen.rdfleet.webservices.gen.ResponseMessages;
import com.realdolmen.rdfleet.webservices.gen.UpdateCarStatistics;
import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.webservices.repositories.CarRepositoryImpl;
import com.realdolmen.rdfleet.webservices.repositories.EmployeeRepositoryImpl;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ResponseMessages updateCarStatistics(Employees parameters) {
        List<Employees.Employee> employees = parameters.getEmployee();
        System.out.println("Executing updateCarStatistics");
        ResponseMessages responseMessagesElement = new ResponseMessages();
        List<String> responseMessages = responseMessagesElement.getResponseMessage();
        Optional<Employee> employee;
        Car car;
        for(Employees.Employee currEmployee : employees) {
            employee = Optional.ofNullable(employeeRepository.findEmployeeByEmail(currEmployee.getEmail()));
            if(employee.isPresent() && employee.get().getCurrentCar() != null) {
                car = employee.get().getCurrentCar();
                car.setMileage(currEmployee.getCar().getMileage());
                car.setAmountOfRefuels(currEmployee.getCar().getAmountOfRefuels().intValue());
                carRepository.saveCar(car);
                responseMessages.add("Successfully updated data for user: " + currEmployee.getEmail() + "!");
            }
            else {
                responseMessages.add("No Employee found for " + currEmployee.getEmail() + "!");
            }
        }
        return responseMessagesElement;
    }
}
