package com.realdolmen.rdfleet.controllers;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.services.implementations.CarOptionServiceImpl;
import com.realdolmen.rdfleet.services.implementations.CarTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

/**
 * Created by ewtax45 on 5/11/2015.
 */
@Controller
@RequestMapping("/order")
@SessionAttributes({"car", "order"})
public class OrderController {
    @Autowired
    private CarTypeServiceImpl carTypeService;

    @Autowired
    private CarOptionServiceImpl carOptionService;

    @ModelAttribute("car")
    public Car initCar() {
        return new Car();
    }

    @RequestMapping(value = "/{id}/caroptions", method = RequestMethod.GET)
    public String getOrderOptions(@PathVariable("id") Long id, @ModelAttribute("car") Car car, Model model) {
        car.setCarType(carTypeService.findById(id));
        model.addAttribute("carOptions", carOptionService.findAllCarOptions());
        return "orderOptions";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String postOrderOptions(@ModelAttribute("car") Car car) {
        return "redirect:/order/summary";
    }

    @RequestMapping(value = "/summary", method = RequestMethod.GET)
    public String getSummary(@ModelAttribute("car") Car car) {

        return "orderSummary";
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public String postSummary(@ModelAttribute("car") Car car, SessionStatus sessionStatus) {
        //hier alle validatieshit
        sessionStatus.isComplete();
        return "redirect:/";
    }
}
