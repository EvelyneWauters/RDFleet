package com.realdolmen.rdfleet.services.definitions;

import com.realdolmen.rdfleet.entities.Order;
import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.options.OptionListObject;
import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.services.DTO.CarTypeDTO;
import com.realdolmen.rdfleet.services.DTO.EmployeeDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by JDOAX80 on 4/11/2015.
 */
public interface OrderService {
    //TODO: Write services interface
    Order getOrderForEmployee(Employee employee);

    Order createOrder(CarTypeDTO carType, EmployeeDTO employee, OptionListObject optionListObject);

    List<Order> findAllOrders();


    }
