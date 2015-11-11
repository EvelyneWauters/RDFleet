package com.realdolmen.rdfleet.services.definitions;

import com.realdolmen.rdfleet.entities.Order;
import com.realdolmen.rdfleet.entities.employee.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by JDOAX80 on 4/11/2015.
 */
public interface OrderService {
    //TODO: Write services interface
    Order getOrderForEmployee(Employee employee);
}
