package com.realdolmen.rdfleet.controllers;

import com.realdolmen.rdfleet.services.implementations.CarServiceImpl;
import com.realdolmen.rdfleet.entities.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMappingName;

/**
 * Created by EWTAX45 on 28/10/2015.
 */
@Controller
@RequestMapping(value = "/car")
public class CarController {
    @Autowired
    private CarServiceImpl carServiceImpl;


    @RequestMapping(value="/all", method = RequestMethod.GET)
    public String carList(Model model)  {
        model.addAttribute(carServiceImpl.findAll());
        List<Car> oldCarList = carServiceImpl.findAllNoLongerInUse();
        model.addAttribute("oldCarList", oldCarList);
        return "cars";
    }


    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeCar(@PathVariable Long id)    {
        carServiceImpl.removeCar(id);
        return "redirect:" + fromMappingName("CC#carList").build();
    }



    @RequestMapping(value="/newcar", method=RequestMethod.POST)
    public String createCar(@PathVariable @Valid Car car)  {
        carServiceImpl.createCar(car);
        return "cars";
    }

}
