package com.realdolmen.rdfleet.services.definitions;

import com.realdolmen.rdfleet.DTO.CarTypeDTO;
import com.realdolmen.rdfleet.DTO.EmployeeDTO;
import com.realdolmen.rdfleet.entities.Order;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.options.OptionListObject;
import com.realdolmen.rdfleet.entities.employee.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by JDOAX80 on 4/11/2015.
 */
public interface OrderService {
    //TODO: Write service interface
    Order getOrderForEmployee(Employee employee);

    void createOrder(CarTypeDTO carType, EmployeeDTO employee, OptionListObject optionListObject);

    }
