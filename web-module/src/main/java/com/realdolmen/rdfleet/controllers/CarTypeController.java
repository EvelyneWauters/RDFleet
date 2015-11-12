package com.realdolmen.rdfleet.controllers;

import com.realdolmen.rdfleet.services.DTO.CarTypeDTO;
import com.realdolmen.rdfleet.entities.car.enums.WinterTyresRimType;
import com.realdolmen.rdfleet.services.definitions.CarService;
import com.realdolmen.rdfleet.entities.car.enums.FuelType;
import com.realdolmen.rdfleet.services.implementations.CarTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMappingName;


@Controller
@RequestMapping("/public/cartype")
public class CarTypeController {
    @Autowired
    private CarTypeServiceImpl carTypeServiceImpl;
    

    @Autowired
    CarService carService;


    //return all available cars (sorted on category)
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String carTypeList(Model model) {
        List<CarTypeDTO> catalog = carTypeServiceImpl.findAllAvailableCarTypes();
        model.addAttribute("carTypeList", catalog);
        return "cartypelist";
    }

    //GET-method of the create-page
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String carTypeForm(@RequestParam(value = "id", required = false) Long carTypeId, Model model) {
        if (carTypeId != null) {
            model.addAttribute("carTypeDTO", carTypeServiceImpl.findById(carTypeId));//Voegt een bestaande cartypeDTO toe aan het model
        } else {
            model.addAttribute("carTypeDTO", new CarTypeDTO()); //Voegt een nieuwe cartypeDTO toe aan het model
        }
        return "cartypeform";
    }


    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String createCarType(@Valid CarTypeDTO carTypeDTO, BindingResult errors) {
        if (errors.hasErrors()) {
            return "cartypeform";
        }
        carTypeServiceImpl.createCarType(carTypeDTO);//creates a new carType
        return "redirect:" + fromMappingName("CTC#carTypeList").build();
    }

    @RequestMapping(value= "/form/{carTypeId}", method = RequestMethod.POST)
    public String updateCarType(@PathVariable("carTypeId") Long id, @Valid CarTypeDTO carTypeDTO, BindingResult errors) {
        if (errors.hasErrors()) {
            return "cartypeform";
        }
        carTypeServiceImpl.updateExistingCarType(id, carTypeDTO);//updates a carType
        return "redirect:" + fromMappingName("CTC#carTypeList").build();
    }

    //find carType by id and show details
    @RequestMapping(value = "/id/{id}", method = GET)
    public String carTypeById(@PathVariable("id") Long carTypeId, Model model) {
        model.addAttribute("carTypeDTO", carTypeServiceImpl.findById(carTypeId));
        return "cartypedetail";
    }


    //delete carType
    @RequestMapping(value = "/delete/id/{id}")
    public String removeCarType(@PathVariable("id") Long carTypeId) {
        carTypeServiceImpl.removeCarTypeFromList(carTypeId);
        return "redirect:" + fromMappingName("CTC#carTypeList").build();
    }


    //put fuelType-enum values in a list so we can use it for the dropdown menu
    @ModelAttribute(value = "fueltypes")
    public List<FuelType> fueltypes() {
        List<FuelType> fuelTypes = new ArrayList<>();
        for (FuelType g : FuelType.values()) {
            fuelTypes.add(g);
        }
        return fuelTypes;
    }


    //put winterRimTypes-enum values in a list so we can use it for the dropdown menu
    @ModelAttribute(value = "winterTyresRimTypes")
    public List<WinterTyresRimType> winterTyresRimTypes() {
        List<WinterTyresRimType> winterTyresRimTypes = new ArrayList<>();
        for (WinterTyresRimType g : WinterTyresRimType.values()) {
            winterTyresRimTypes.add(g);
        }
        return winterTyresRimTypes;
    }

}
