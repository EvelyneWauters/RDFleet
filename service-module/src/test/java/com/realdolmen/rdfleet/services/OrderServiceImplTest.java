package com.realdolmen.rdfleet.services;

import com.realdolmen.rdfleet.entities.Order;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import com.realdolmen.rdfleet.entities.car.options.CarOption;
import com.realdolmen.rdfleet.entities.car.options.OptionListObject;
import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.repositories.*;
import com.realdolmen.rdfleet.services.DTO.CarTypeDTO;
import com.realdolmen.rdfleet.services.DTO.EmployeeDTO;
import com.realdolmen.rdfleet.services.implementations.OrderServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by JDOAX80 on 4/11/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {

    private OrderServiceImpl orderService;
    private CarTypeRepository carTypeRepository;
    private CarOptionRepository carOptionRepository;
    private EmployeeRepository employeeRepository;
    private OrderRepository orderRepository;
    private Employee employee;
    private Optional<Order> order;

    @Before
    public void init() {
        orderRepository = mock(OrderRepository.class);
        carTypeRepository = mock(CarTypeRepository.class);
        employeeRepository = mock(EmployeeRepository.class);
        carOptionRepository = mock(CarOptionRepository.class);
        orderService = new OrderServiceImpl(orderRepository, carOptionRepository, employeeRepository, carTypeRepository);
        employee = new Employee();
        employee.setEmail("bla@bla.com");
        employee.setPasswordHash("bla");
        Order order = new Order();
        order.setEmployee(employee);
        CarType carType = new CarType();
        CarModel carmodel = new CarModel();
        carmodel.setModelName("model");
        Brand brand = new Brand();
        brand.setName("brand");
        carType.setCarModel(carmodel);
        carType.setBrand(brand);
        order.setCarType(carType);
        this.order = Optional.of(order);

    }

    @Test
    public void getOrderForEmployeeCanBeSuccessfullyCalledFromService() {
        when(orderRepository.findOneByEmployee(employee)).thenReturn(order);
        orderService.getOrderForEmployee(employee);
        verify(orderRepository).findOneByEmployee(employee);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getOrderForEmployeeThrowsIllegalArgumentExceptionWhenThereIsNoOrderPresentForThisEmployee() {
        when(orderRepository.findOneByEmployee(employee)).thenReturn(Optional.empty());
        orderService.getOrderForEmployee(employee);
        verify(orderRepository).findOneByEmployee(employee);
    }

    @Test
    public void createOrderWithOptionsCanBeSuccessfullyCalledFromService() {
        CarTypeDTO carTypeDTO = new CarTypeDTO();
        carTypeDTO.setId(1L);
        CarOption carOption = new CarOption();
        OptionListObject optionListObject = new OptionListObject();
        List<String> selectedOptions = new ArrayList<>();
        selectedOptions.add("5");
        optionListObject.setSelectedOptions(selectedOptions);
        CarType carType = new CarType();
        carType.setId(1L);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmail("bla@bla.com");
        Employee employee = new Employee();
        employee.setEmail("bla@bla.com");
        when(carTypeRepository.findOne(1L)).thenReturn(carType);
        when(employeeRepository.findOneByEmail("bla@bla.com")).thenReturn(Optional.ofNullable(employee));
        when(carOptionRepository.findOne(Long.parseLong("5"))).thenReturn(carOption);
        Order currOrder = orderService.createOrder(carTypeDTO, employeeDTO, optionListObject);
        verify(carTypeRepository).findOne(anyLong());
        verify(employeeRepository).findOneByEmail("bla@bla.com");
        verify(carOptionRepository).findOne(anyLong());
        verify(orderRepository).save(any(Order.class));
    }

    @Test
    public void createOrderWithoutOptionsCanBeSuccessfullyCalledFromService() {
        CarTypeDTO carTypeDTO = new CarTypeDTO();
        carTypeDTO.setId(1L);
        OptionListObject optionListObject = new OptionListObject();
        List<String> selectedOptions = new ArrayList<>();
        optionListObject.setSelectedOptions(selectedOptions);
        CarType carType = new CarType();
        carType.setId(1L);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmail("bla@bla.com");
        Employee employee = new Employee();
        employee.setEmail("bla@bla.com");
        when(carTypeRepository.findOne(1L)).thenReturn(carType);
        when(employeeRepository.findOneByEmail("bla@bla.com")).thenReturn(Optional.ofNullable(employee));
        orderService.createOrder(carTypeDTO, employeeDTO, optionListObject);
        verify(carTypeRepository).findOne(anyLong());
        verify(employeeRepository).findOneByEmail("bla@bla.com");
        verify(orderRepository).save(any(Order.class));
        assertEquals(0, order.get().getOptions().size());
    }

    @Test
    public void findAllOrdersCanBeSuccessfullyCalledFromService() {
        orderService.findAllOrders();
        verify(orderRepository).findAll();
    }

    @Test
    public void findByIdCanBeSuccessfullyCalledFromService() {
        orderService.findById(1L);
        verify(orderRepository).findOne(1L);
    }
}
