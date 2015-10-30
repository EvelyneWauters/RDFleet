package com.realdolmen.rdfleet.controllers.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMappingName;

/**
 * Created by JDOAX80 on 28/10/2015.
 */
@Controller
public class LoginController {
    @Autowired
    private Authentication authentication;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(@RequestParam Optional<String> error, Model model) {
        model.addAttribute("error", error);
        return  "login";
    }

}
