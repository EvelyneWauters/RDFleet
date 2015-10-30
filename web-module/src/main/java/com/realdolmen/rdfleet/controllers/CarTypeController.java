package com.realdolmen.rdfleet.controllers;

import com.realdolmen.rdfleet.services.implementations.CarServiceImpl;
import com.realdolmen.rdfleet.services.implementations.CarTypeServiceImpl;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.enums.FuelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
@RequestMapping("/cartype")
public class CarTypeController {
    @Autowired
    CarTypeServiceImpl carTypeServiceImpl;

    @Autowired
    CarServiceImpl carServiceImpl;


    //return all available cars (sorted on category)
    @RequestMapping(value="/all", method = RequestMethod.GET)
    public String carTypeList(Model model)  {
        model.addAttribute(carTypeServiceImpl.findAllAvailableCars());
        return "cartypelist";
    }


    //find carType by id and show details
    @RequestMapping(value = "/id/{id}", method = GET)
    public String carTypeById(Map<String, Object> model, @PathVariable("id") Long carTypeId) {
        model.put("carType", carTypeServiceImpl.findById(carTypeId));
        return "cartypedetail";
    }


    //GET-method of the create-page
    @RequestMapping(value="/form", method = RequestMethod.GET)
    public String carTypeForm(Map<String, Object> model, @RequestParam(value = "id",required = false) Long carTypeId)    {
        if(carTypeId!=null)    {
            model.put("cartype", carTypeServiceImpl.findById(carTypeId));
        } else {
            model.put("cartype", new CarType());
        }
        return "cartypeform";
    }



    //POST-method of the create-page
    @RequestMapping(value= "/create", method = RequestMethod.POST)
    public String createCarType(@Valid CarType carType, BindingResult bindingResult)  {
//        if(bindingResult.hasErrors())   {
//            return "carform";
//        }
        carTypeServiceImpl.createOrUpdateCarType(carType);
        return "redirect:/cartype/all";
    }


    //delete carType
    @RequestMapping(value="/delete/id/{id}")
    public String removeCarType(@PathVariable("id") Long carTypeId)    {
        carTypeServiceImpl.removeCarTypeFromList(carTypeId);
        return "redirect:/cartype/all";
    }




    //put fuelType-enum values in a list so we can use it for the dropdown menu
    @ModelAttribute(value = "fueltypes")
    public List<FuelType> genders(){

        List<FuelType> fuelTypes = new ArrayList<>();
        for (FuelType g: FuelType.values()){
            fuelTypes.add(g);
        }
        return fuelTypes;
    }

}
