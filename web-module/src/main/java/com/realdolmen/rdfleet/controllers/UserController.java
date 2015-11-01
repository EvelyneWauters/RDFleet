package com.realdolmen.rdfleet.controllers;

import com.realdolmen.rdfleet.entities.employee.User;
import com.realdolmen.rdfleet.services.implementations.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by EWTAX45 on 1/11/2015.
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    EmployeeServiceImpl employeeService;

    //return all users (sorted on name)
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String userList(Model model) {
        List<User> catalog = carTypeServiceImpl.findAllAvailableCarTypes();
        model.addAttribute(catalog);
        return "cartypelist";
    }

}
