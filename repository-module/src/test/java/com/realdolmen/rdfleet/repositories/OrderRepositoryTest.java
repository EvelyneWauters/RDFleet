package com.realdolmen.rdfleet.repositories;

import com.realdolmen.rdfleet.entities.Order;
import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import com.realdolmen.rdfleet.entities.car.options.CarOption;
import com.realdolmen.rdfleet.entities.employee.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import javax.validation.ConstraintViolationException;
import java.util.NoSuchElementException;

/**
 * Created by JDOAX80 on 4/11/2015.
 */
public class OrderRepositoryTest extends RepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    private Order order;

    @Before
    public void init() {
        super.init();
        order = new Order();
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void orderCantBeCreatedWithoutEmployee() {
        CarType carType = getCarType();
        order.setCarType(carType);
        orderRepository.save(order);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void orderCantBeCreatedWithoutCarType() {
        Employee employee = getEmployee();
        order.setEmployee(employee);
        orderRepository.save(order);
    }

    @Test
    public void orderCanBeFoundByEmployee() {
        order.setEmployee(getEmployee());
        order.setCarType(getCarType());
        orderRepository.save(order);
        Order currOrder = orderRepository.findOneByEmployee(getEmployee()).get();
        assertNotNull(currOrder.getId());
    }

    @Test(expected = NoSuchElementException.class)
    public void orderCantBeFoundByEmployeeIfNoValidEmployee() {
        Order currOrder = orderRepository.findOneByEmployee(getEmployee()).get();
    }

    @Test(expected = NoSuchElementException.class)
    public void findOneByEmployeeThrowsExceptionWhenGivenAnInvalidEmployee() {
        Employee employee = getEmployee();
        CarType carType = getCarType();
        order.setCarType(carType);
        order.setEmployee(employee);
        Order currOrder = orderRepository.findOneByEmployee(employee).get();
        assertNull(currOrder.getId());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void orderMustHaveAnUniqueEmployee() {
        Employee employee = getEmployee();
        CarType carType = getCarType();
        Order secondOrder = new Order();
        order.setCarType(carType);
        order.setEmployee(employee);
        secondOrder.setCarType(carType);
        secondOrder.setEmployee(employee);
        orderRepository.save(order);
        orderRepository.save(secondOrder);
    }
}
