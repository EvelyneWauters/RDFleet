package com.realdolmen.rdfleet.services.implementations;

import com.realdolmen.rdfleet.entities.Order;
import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.repositories.OrderRepository;
import com.realdolmen.rdfleet.services.definitions.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by JDOAX80 on 4/11/2015.
 */
@Service
public class OrderServiceImpl implements OrderService{
    //TODO: Write service implementation
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Order getOrderForEmployee(Employee employee) {
        Optional<Order> orderOptional = orderRepository.findOneByEmployee(employee);
        if(orderOptional.isPresent()) {
            return orderOptional.get();
        }
        else {
            throw new IllegalArgumentException("There is no order present for this employee");
        }
    }
}
