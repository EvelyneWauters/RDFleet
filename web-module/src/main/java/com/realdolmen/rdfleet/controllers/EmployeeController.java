package com.realdolmen.rdfleet.controllers;

import com.realdolmen.rdfleet.DTO.EmployeeDTO;
import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.services.implementations.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMappingName;

/**
 * Created by EWTAX45 on 1/11/2015.
 */
@Controller
@RequestMapping("/admin/user")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    //return all users (sorted on name)
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String employeeList(Model model) {
        List<Employee> allEmployees = (List) employeeService.getAllEmployees();
        model.addAttribute(allEmployees);
        return "employeelist";
    }


    //GET-method of the create-page
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String employeeForm(@RequestParam(value = "id", required = false) Long employeeId, Map<String, Object> model) {
        if (employeeId != null) {
            model.put("employee", employeeService.getEmployeeById(employeeId));
        } else {
            model.put("employee", new Employee());
        }
        return "employeeform";
    }


    //POST-method of the create-page
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String createCarType(@Valid EmployeeDTO employee, Errors errors) {
        if(errors.hasErrors())   {
            return "employeeform";
        }
//        Optional<Employee> employeeById = employeeService.getEmployeeById(employee.getId());
//        Employee editedEmployee = employeeById.get();
//        editedEmployee.setFunctionalLevel(employee.getFunctionalLevel());
        employeeService.updateEmployee(employee);
        return "redirect:" + fromMappingName("EC#employeeList").build();
    }


}
