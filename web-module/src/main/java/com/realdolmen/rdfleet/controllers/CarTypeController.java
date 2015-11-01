package com.realdolmen.rdfleet.controllers;

import com.realdolmen.rdfleet.CarService;
import com.realdolmen.rdfleet.CarTypeService;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.FuelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMappingName;


@Controller
@RequestMapping("/public/cartype")
public class CarTypeController {
    @Autowired
    CarTypeService carTypeService;

    @Autowired
    CarService carService;


    //return all available cars (sorted on category)
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String carTypeList(Model model) {

        List<CarType> catalog = carTypeService.findAllCarTypes();
        for (Iterator<CarType> it = catalog.listIterator(); it.hasNext(); ) {
            CarType carType = it.next();
            if (carType.getIsAvailable() == false) {
                it.remove();
            }
        }
        model.addAttribute(catalog);
        return "cartypelist";
    }




    //GET-method of the create-page
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String carTypeForm(@RequestParam(value = "id", required = false) Long carTypeId, Map<String, Object> model) {
        if (carTypeId != null) {
            model.put("carType", carTypeService.findById(carTypeId));
        } else {
            model.put("carType", new CarType());
        }
        return "cartypeform";
    }


    //POST-method of the create-page
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String createCarType(@Valid CarType carType, Errors errors) {
        if(errors.hasErrors())   {
            return "cartypeform";
        }
        carTypeService.createOrUpdateCarType(carType);
        return "redirect:" + fromMappingName("CTC#carTypeList").build();

    }



    //find carType by id and show details
    @RequestMapping(value = "/id/{id}", method = GET)
    public String carTypeById(@PathVariable("id") Long carTypeId, Map<String, Object> model) {
        model.put("carType", carTypeService.findById(carTypeId));
        return "cartypedetail";
    }


    //delete carType
    @RequestMapping(value = "/delete/id/{id}")
    public String removeCarType(@PathVariable("id") Long carTypeId) {
        carTypeService.removeCarTypeFromList(carTypeId);
        return "redirect:" + fromMappingName("CTC#carTypeList").build();
    }


    //put fuelType-enum values in a list so we can use it for the dropdown menu
    @ModelAttribute(value = "fueltypes")
    public List<FuelType> genders() {

        List<FuelType> fuelTypes = new ArrayList<>();
        for (FuelType g : FuelType.values()) {
            fuelTypes.add(g);
        }
        return fuelTypes;
    }

}
