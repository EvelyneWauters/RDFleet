package com.realdolmen.rdfleet.services.definitions;

import com.realdolmen.rdfleet.entities.Order;
import com.realdolmen.rdfleet.services.DTO.CarDTO;
import com.realdolmen.rdfleet.services.DTO.EmployeeDTO;
import com.realdolmen.rdfleet.services.DTO.OrderDTO;
import com.realdolmen.rdfleet.services.DTO.EmployeeDTO;
import com.realdolmen.rdfleet.entities.employee.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by JDOAX80 on 28/10/2015.
 */
public interface EmployeeService {
    //TODO:Nagaan waar transacties nodig zijn en welk type ze nodig hebben.
    //Is dit wel correct?: Is het niet eerder DTO's gebruiken aan de webkant louter voor validatie, en dan per direct de mapping te doen alvorens de services te gebruiken?
    //Aldus kunnen de services gewoon de entity objecten returnen.
    EmployeeDTO getEmployeeById(long id);

    EmployeeDTO getEmployeeDtoByEmail(String email);

    Optional<Employee> getOptionalEmployeeByEmail(String email);

    Collection<EmployeeDTO> getAllEmployees();

    Employee createEmployee(EmployeeDTO employeeDTO);

    void updateEmployee(EmployeeDTO employeeDTO);

    String hashPassword(String password);

    CarDTO assignCarToEmployee(Order order, int leasingDurationInYears, String numberPlate , String vinNumber);

    CarDTO assignPoolCarToEmployee(EmployeeDTO employeeDTO, CarDTO car);

    List<EmployeeDTO> getAllEmployeesByActive(boolean isActive);
}
