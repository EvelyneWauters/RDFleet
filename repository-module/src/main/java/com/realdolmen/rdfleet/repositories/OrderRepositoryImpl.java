package com.realdolmen.rdfleet.repositories;

import com.realdolmen.rdfleet.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by JDOAX80 on 4/11/2015.
 */
public class OrderRepositoryImpl implements OrderRepositoryInterface {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void createOrder(Order order) {
        order.getEmployee();
    }
}
