package com.realdolmen.rdfleet.controllers;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.services.definitions.OrderService;
import com.realdolmen.rdfleet.services.implementations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

/**
 * Created by ewtax45 on 5/11/2015.
 */
@Controller
@RequestMapping("/admin/order")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private EmployeeServiceImpl employeeService;


    @RequestMapping(value="/all", method = RequestMethod.GET)
    public String carList(Model model)  {
        model.addAttribute(orderService.findAllOrders());
        return "orderlist";
    }

}
