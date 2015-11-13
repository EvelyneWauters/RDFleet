package com.realdolmen.rdfleet.services;

import com.realdolmen.rdfleet.entities.Order;
import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.repositories.CarRepository;
import com.realdolmen.rdfleet.repositories.OrderRepository;
import com.realdolmen.rdfleet.services.DTO.EmployeeDTO;
import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.repositories.EmployeeRepository;
import com.realdolmen.rdfleet.services.implementations.EmployeeServiceImpl;
import com.realdolmen.rdfleet.services.mappers.CarMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

/**
 * Created by JDOAX80 on 2/11/2015.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(CarMapper.class)
public class EmployeeServiceImplTest {

    private EmployeeServiceImpl employeeService;
    private EmployeeRepository employeeRepository;
    private OrderRepository orderRepository;
    private CarRepository carRepository;
    private EmployeeDTO employeeDTO;
    private Employee employee;

    @Before
    public void init() {
        PowerMockito.mockStatic(CarMapper.class);
        employeeRepository = mock(EmployeeRepository.class);
        orderRepository = mock(OrderRepository.class);
        carRepository = mock(CarRepository.class);
        employeeService = new EmployeeServiceImpl(employeeRepository, orderRepository, carRepository);
        employee = new Employee();
        employeeDTO = new EmployeeDTO();
        employee.setEmail("bla@bla.com");
        employee.setPasswordHash("bla");
        employeeDTO.setEmail("bla@bla.com");
        employeeDTO.setPassword("bla");
    }

    @Test
    public void getEmployeeByIdCanBeSuccessfullyCalledFromService() {
        when(employeeRepository.findOne(1L)).thenReturn(employee);
        employeeService.getEmployeeById(1);
        verify(employeeRepository).findOne(1L);
    }

    @Test
    public void getEmployeeDtoByEmailCanBeSuccessfullyCalledFromService() {
        when(employeeRepository.findOneByEmail(employee.getEmail())).thenReturn(Optional.ofNullable(employee));
        employeeService.getEmployeeDtoByEmail(employee.getEmail());
        verify(employeeRepository).findOneByEmail(employee.getEmail());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getEmployeeDtoByEmailThrowsIllegalArgumentExceptionWhenNoEmployeeIsFoundForGivenEmail() {
        when(employeeRepository.findOneByEmail(employee.getEmail())).thenReturn(Optional.empty());
        employeeService.getEmployeeDtoByEmail(employee.getEmail());
        verify(employeeRepository).findOneByEmail(employee.getEmail());
    }

    @Test
    public void getOptionalEmployeeByEmailCanBeSuccessfullyCalledFromService() {
        employeeService.getOptionalEmployeeByEmail(employee.getEmail());
        verify(employeeRepository).findOneByEmail(employee.getEmail());
    }

    @Test
    public void getAllEmployeesCanBeSuccessfullyCalledFromService() {
        employeeService.getAllEmployees();
        verify(employeeRepository).findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "email")));
    }

    @Test
    public void createEmployeeCanBeSuccessfullyCalledFromService() {
        employeeService.createEmployee(employeeDTO);
        verify(employeeRepository).save(any(Employee.class));
    }

    @Test
    public void assignCarToEmployeeCanBeSuccessfullyCalledFromService() {
        Order order = new Order();
        CarType carType = new CarType();
        Car car = new Car();
        order.setCarType(carType);
        order.setEmployee(employee);
        car.setCarType(carType);
        car.setStartLeasing(LocalDate.now());
        car.setLeasingDurationYears(4);
        car.setNumberPlate("1-JNL-715");
        car.setVinNumber("15");
        EmployeeServiceImpl employeeServiceSpy = spy(employeeService);
        when(employeeServiceSpy.createNewCarFromOrder(order, 4, "1-JNL-715", "15")).thenReturn(car);
        when(CarMapper.mapCarObjectToCarDTO(new Car())).thenReturn(null);
        employeeService.assignCarToEmployee(order, 4, "1-JNL-715", "15");
        verify(employeeRepository).save(any(Employee.class));
        verifyStatic();
        CarMapper.mapCarObjectToCarDTO(any(Car.class));
    }

    @Test
    public void createNewCarFromOrderSuccessfullyCreatesNewCar() {

    }

    @Test
    public void moveCurrentCarToCarHistorySuccessfullyMovesCarToHistory() {

    }





//    @Test(expected = IllegalArgumentException.class)
//    public void employeeFunctionalLevelCantBeLowerThanOne() {
//        Employee employee = new Employee();
//        employee.setFunctionalLevel(0);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void employeeFunctionalLevelCantBeHigherThanSeven() {
//        Employee employee = new Employee();
//        employee.setFunctionalLevel(8);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void employeeFunctionalLevelCantBeNegative() {
//        Employee employee = new Employee();
//        employee.setFunctionalLevel(-1);
//    }


}
