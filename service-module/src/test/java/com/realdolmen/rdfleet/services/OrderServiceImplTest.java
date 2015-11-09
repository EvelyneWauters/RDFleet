package com.realdolmen.rdfleet.services;

import com.realdolmen.rdfleet.entities.Order;
import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.repositories.OrderRepository;
import com.realdolmen.rdfleet.services.implementations.OrderServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by JDOAX80 on 4/11/2015.
 */
public class OrderServiceImplTest extends ServicesTest {

    //TODO: Write service test, WERKT NIET
    private OrderServiceImpl orderService;
    private OrderRepository orderRepository;
    private Employee employee;
    private Optional<Order> order;

    @Before
    public void init() {
        orderRepository = mock(OrderRepository.class);
        orderService = new OrderServiceImpl(orderRepository);
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
    public void getOrderByEmployeeCanBeCalledFromService() {
        orderService.getOrderForEmployee(employee);
        verify(orderRepository.findOneByEmployee(employee));
    }
}
