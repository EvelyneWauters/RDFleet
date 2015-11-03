package com.realdolmen.rdfleet.services.mappers;

import com.realdolmen.rdfleet.DTO.EmployeeDTO;
import com.realdolmen.rdfleet.entities.employee.Employee;


public class EmployeeMapper {

    public static Employee mapEmployeeDTOToEmployeeObject(EmployeeDTO dto, Employee employee) {
        employee.setActive(dto.getActive());
        employee.setFunctionalLevel(dto.getFunctionalLevel());
        return employee;
        }


    public static EmployeeDTO mapEmployeeToEmployeeDtoObject(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();

        dto.setEmail(employee.getEmail());
        dto.setActive(employee.getActive());
        dto.setFunctionalLevel(employee.getFunctionalLevel());
        dto.setRole(employee.getRole());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        return dto;
        }
}
