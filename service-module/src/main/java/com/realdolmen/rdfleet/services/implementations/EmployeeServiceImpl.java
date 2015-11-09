package com.realdolmen.rdfleet.services.implementations;

import com.realdolmen.rdfleet.DTO.EmployeeDTO;
import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.repositories.EmployeeRepository;
import com.realdolmen.rdfleet.services.definitions.EmployeeService;
import com.realdolmen.rdfleet.services.mappers.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.realdolmen.rdfleet.services.mappers.EmployeeMapper.mapEmployeeToEmployeeDtoObject;

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
    public EmployeeDTO getEmployeeById(long id) {
        Optional<Employee> employee = Optional.ofNullable(employeeRepository.findOne(id));
        if(employee.isPresent())    {
            return mapEmployeeToEmployeeDtoObject(employee.get());
        }   else    {
            throw new IllegalArgumentException("there is no employee found with id " + id);
        }
    }

    @Override
    public EmployeeDTO getEmployeeDtoByEmail(String email) {
        Optional<Employee> employee = employeeRepository.findOneByEmail(email);
        if(employee.isPresent())    {
            return mapEmployeeToEmployeeDtoObject(employee.get());
        }   else    {
            throw new IllegalArgumentException("there is no employee found with email ' " + email + " '.");
        }
    }


    @Override
    public Optional<Employee> getOptionalEmployeeByEmail(String email) {
        return employeeRepository.findOneByEmail(email);
    }

    @Override
    public Collection<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll(new Sort("email"));
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee employee : employeeList) {
            employeeDTOList.add(mapEmployeeToEmployeeDtoObject(employee));
        }
        return employeeDTOList;
    }

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmail(employeeDTO.getEmail());
        employee.setPasswordHash(hashPassword(employeeDTO.getPassword()));
        employee.setRole(employeeDTO.getRole());
        return employeeRepository.save(employee);
    }

    @Override
    public String hashPassword(String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    public void updateEmployee(EmployeeDTO employeeDTO)    {
        Employee employee = employeeRepository.findOneByEmail(employeeDTO.getEmail()).get();
        if(checkIfValidEntity(employee)) {
            employee.setFunctionalLevel(employeeDTO.getFunctionalLevel());
            employee.setActive(employeeDTO.getActive());
            employeeRepository.save(employee);
        }
    }


    public boolean checkIfValidEntity(Employee employee) {
        int functionalLevel = employee.getFunctionalLevel();
        if (functionalLevel < 1 || functionalLevel > 7)
            throw new IllegalArgumentException("The functional level can not be lower than 1 or higher than 7!");
        return true;
    }
}
