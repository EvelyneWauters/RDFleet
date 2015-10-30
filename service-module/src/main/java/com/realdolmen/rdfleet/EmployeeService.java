package com.realdolmen.rdfleet;

import com.realdolmen.rdfleet.DTO.EmployeeDTO;
import com.realdolmen.rdfleet.entities.Employee;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by JDOAX80 on 28/10/2015.
 */
public interface EmployeeService {

    Optional<Employee> getUserById(long id);

    Optional<Employee> getUserByEmail(String email);

    Collection<Employee> getAllUsers();

    Employee create(EmployeeDTO employeeDTO);

}
