package com.realdolmen.rdfleet.services.implementations;

import com.realdolmen.rdfleet.entities.Order;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.options.CarOption;
import com.realdolmen.rdfleet.entities.car.options.OptionListObject;
import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.repositories.*;
import com.realdolmen.rdfleet.services.DTO.CarTypeDTO;
import com.realdolmen.rdfleet.services.DTO.EmployeeDTO;
import com.realdolmen.rdfleet.services.definitions.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by JDOAX80 on 4/11/2015.
 */
@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;

    @Autowired
    private CarTypeRepository carTypeRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CarOptionRepository carOptionRepository;

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

    @Override
    public Order createOrder(CarTypeDTO carTypeDTO, EmployeeDTO employeeDTO, OptionListObject optionListObject) {
        CarType carType = carTypeRepository.findOne(carTypeDTO.getId());
        Employee employee = employeeRepository.findOneByEmail(employeeDTO.getEmail()).get();
        List<String> selectedOptions = optionListObject.getSelectedOptions();
        List<CarOption> carOptions = new ArrayList<>();
        Order order = new Order(carType, employee);
        if(selectedOptions != null && selectedOptions.size() > 0) {
            for (String selectedOption : selectedOptions) {
                carOptions.add(carOptionRepository.findOne(Long.parseLong(selectedOption)));
            }
            order.setOptions(carOptions);
        }
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }


    @Override
    public Order findById(Long id)  {
        return orderRepository.findOne(id);
    }


//    @Override
//    public Order createOrderPoolCar(CarDTO carDTO, EmployeeDTO employeeDTO) {
//        Car car = carRepository.findOne(carDTO.getId());
//        Employee employee = employeeRepository.findOneByEmail(employeeDTO.getEmail()).get();
//        return orderRepository.save(new Order(car, employee));
//
//
//    }
}
