package com.realdolmen.rdfleet.services.definitions;

import com.realdolmen.rdfleet.DTO.EmployeeDTO;
import com.realdolmen.rdfleet.entities.employee.Employee;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by JDOAX80 on 28/10/2015.
 */
public interface EmployeeService {

    EmployeeDTO getEmployeeById(long id);

    EmployeeDTO getEmployeeDtoByEmail(String email);

    Optional<Employee> getOptionalEmployeeByEmail(String email);

    Collection<EmployeeDTO> getAllEmployees();

    Employee createEmployee(EmployeeDTO employeeDTO);

    void updateEmployee(EmployeeDTO employeeDTO);

    String hashPassword(String password);
}
