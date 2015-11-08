package com.realdolmen.rdfleet.controllers;

import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.services.implementations.CarTypeServiceImpl;
import com.realdolmen.rdfleet.services.implementations.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by ewtax45 on 5/11/2015.
 */
@Controller
@RequestMapping("/browse")
public class BrowseController {

    @Autowired
    CarTypeServiceImpl carTypeService;
    @Autowired
    EmployeeServiceImpl employeeService;

    @RequestMapping("/allcars")
    public String returnAllAvailableCarTypesForFunctionalLevel(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<CarType> carByFunctionalLevel = carTypeService.findCarByFunctionalLevel(employeeService.getEmployeeDtoByEmail(auth.getName()).getFunctionalLevel());
        model.addAttribute("carList", carByFunctionalLevel);
        return "browse-cars";
    }


    //find carType by id and show details
    @RequestMapping(value = "/detail/{id}", method = GET)
    public String carTypeById(@PathVariable("id") Long carTypeId, Map<String, Object> model) {
        model.put("carType", carTypeService.findById(carTypeId));
        return "cartypedetail";
    }
}
