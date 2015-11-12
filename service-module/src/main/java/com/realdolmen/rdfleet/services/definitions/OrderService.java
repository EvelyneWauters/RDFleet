package com.realdolmen.rdfleet.services.definitions;

import com.realdolmen.rdfleet.entities.Order;
import com.realdolmen.rdfleet.entities.car.options.OptionListObject;
import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.services.DTO.CarTypeDTO;
import com.realdolmen.rdfleet.services.DTO.EmployeeDTO;

import java.util.List;


/**
 * Created by JDOAX80 on 4/11/2015.
 */
public interface OrderService {
    //TODO: Write services interface
    Order getOrderForEmployee(Employee employee);

    Order createOrder(CarTypeDTO carType, EmployeeDTO employee, OptionListObject optionListObject);

    List<Order> findAllOrders();

    Order findById(Long id);

    Double calculateFinalBenefitPerMonth(EmployeeDTO employeeDTO, CarTypeDTO carTypeDTO);


    }
