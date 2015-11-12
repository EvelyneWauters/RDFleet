package com.realdolmen.rdfleet.controllers;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.services.DTO.NewCarAssignation;
import com.realdolmen.rdfleet.services.definitions.OrderService;
import com.realdolmen.rdfleet.services.implementations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Map;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMappingName;

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


    //GET-method of the create-page
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String orderAssign(@RequestParam(value = "id", required = true) Long id, Map<String, Object> model) {
        model.put("order", orderService.findById(id));
//        model.put("car", new Car());
        NewCarAssignation nca = new NewCarAssignation();
        nca.setOrderId(id);

        model.put("car", nca);
        return "orderassign";
    }


    //POST-method of the create-page
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String assignEmployee(@Valid NewCarAssignation nca, Errors errors) {
//        Long id = car.getId();

        employeeService.assignCarToEmployee(orderService.findById(nca.getOrderId()), nca.getLeasingDurationYears(), nca.getNumberPlate(), nca.getVinNumber());
        return "redirect:" + fromMappingName("OC#carList").build();
    }
}
