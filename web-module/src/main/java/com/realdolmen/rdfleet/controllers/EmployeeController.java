package com.realdolmen.rdfleet.controllers;

import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.services.DTO.EmployeeDTO;
import com.realdolmen.rdfleet.services.implementations.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.fromMappingName;

/**
 * Created by EWTAX45 on 1/11/2015.
 */
@Controller
@RequestMapping("/admin/employee")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    //return all users (sorted on email)
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String employeeDTOList(Model model) {
        List<EmployeeDTO> allEmployees = (List) employeeService.getAllEmployeesByActive(true);
        model.addAttribute(allEmployees);
        return "employeelist";
    }


    //GET-method of the create-page
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String employeeForm(@RequestParam(value = "email", required = false) String email, Map<String, Object> model) {
        if (email != null) {
            model.put("employeeDTO", employeeService.getEmployeeDtoByEmail(email));
        } else {
            model.put("employeeDTO", new EmployeeDTO());
        }
        return "employeeform";
    }


    //POST-method of the create-page
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String updateEmployee(@Valid EmployeeDTO employee, Errors errors) {
        if(errors.hasErrors())   {
            return "employeeform";
        }
//        Optional<Employee> employeeById = employeeService.getEmployeeById(employee.getId());
//        Employee editedEmployee = employeeById.get();
//        editedEmployee.setFunctionalLevel(employee.getFunctionalLevel());
        employeeService.updateEmployee(employee);
        return "redirect:" + fromMappingName("EC#employeeDTOList").build();
    }

    //find employee by id and show details
    @RequestMapping(value = "/id/{id}", method = GET)
    public String employeeById(@RequestParam("id") String employeeEmail, Model model) {
//        EmployeeDTO employee = employeeService.getEmployeeById(id);
        Optional<Employee> optionalEmployeeByEmail = employeeService.getOptionalEmployeeByEmail(employeeEmail);
        Employee employee = optionalEmployeeByEmail.get();
        model.addAttribute("employee", employee);
//        model.addAttribute("currentCar", employee.getCurrentCar());
//        model.addAttribute("carHistoryList", employee.getCarHistory());
        return "employeedetail";
    }



}
