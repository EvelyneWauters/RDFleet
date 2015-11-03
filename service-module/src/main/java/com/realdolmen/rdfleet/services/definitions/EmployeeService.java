package com.realdolmen.rdfleet.services.definitions;

import com.realdolmen.rdfleet.DTO.EmployeeDTO;
import com.realdolmen.rdfleet.entities.employee.Employee;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by JDOAX80 on 28/10/2015.
 */
public interface EmployeeService {

    Optional<Employee> getEmployeeById(long id);

    Optional<Employee> getEmployeeByEmail(String email);

    Collection<Employee> getAllEmployees();

    Employee createEmployee(EmployeeDTO employeeDTO);

    void updateEmployee(EmployeeDTO employeeDTO);


}
