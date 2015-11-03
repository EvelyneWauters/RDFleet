package com.realdolmen.rdfleet.services;

import com.realdolmen.rdfleet.DTO.EmployeeDTO;
import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.repositories.EmployeeRepository;
import com.realdolmen.rdfleet.services.implementations.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;

/**
 * Created by JDOAX80 on 2/11/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceImplTest extends ServicesTest {

    private EmployeeServiceImpl employeeService;
    private EmployeeRepository employeeRepository;
    private EmployeeDTO employeeDTO;
    private Employee employee;

    @Before
    public void init() {
        employeeRepository = mock(EmployeeRepository.class);
        employeeService = new EmployeeServiceImpl(employeeRepository);
        employee = new Employee();
        employeeDTO = new EmployeeDTO();
        employee.setEmail("bla@bla.com");
        employee.setPasswordHash("bla");
        employeeDTO.setEmail("bla@bla.com");
        employeeDTO.setPassword("bla");
    }

    @Test
    public void getEmployeeByIdCanBeCalledFromService() {
        employeeService.getEmployeeById(1);
        verify(employeeRepository).findOne(1L);
    }

    @Test
    public void createEmployeeCanBeCalledFromService() {
        employeeService.createEmployee(employeeDTO);
        verify(employeeRepository).save(any(Employee.class));
    }

    @Test
    public void getAllEmployeesCanBeCalledFromService() {
        employeeService.getAllEmployees();
        verify(employeeRepository).findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "email")));
    }

    @Test
    public void getEmployeeByEmailCanBeCalledFromService() {
        employeeService.getOptionalEmployeeByEmail(employee.getEmail());
        verify(employeeRepository).findOneByEmail(employee.getEmail());
    }
}
