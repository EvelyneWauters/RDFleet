package com.realdolmen.rdfleet.controllers;

import com.realdolmen.rdfleet.services.implementations.CurrentUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value="/", method= RequestMethod.GET)
    public String home()    {
        return "index";
    }
}