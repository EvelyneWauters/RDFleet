package com.realdolmen.rdfleet.services.implementations;

import com.realdolmen.rdfleet.DTO.EmployeeDTO;
import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.repositories.EmployeeRepository;
import com.realdolmen.rdfleet.services.definitions.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by JDOAX80 on 28/10/2015.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Optional<Employee> getUserById(long id) {
        return Optional.ofNullable(employeeRepository.findOne(id));
    }

    @Override
    public Optional<Employee> getUserByEmail(String email) {
        return employeeRepository.findOneByEmail(email);
    }

    @Override
    public Collection<Employee> getAllUsers() {
        return employeeRepository.findAll(new Sort("email"));
    }

    @Override
    public Employee create(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmail(employeeDTO.getEmail());
        employee.setPasswordHash(new BCryptPasswordEncoder().encode(employeeDTO.getPassword()));
        employee.setRole(employeeDTO.getRole());
        return employeeRepository.save(employee);
    }

}
