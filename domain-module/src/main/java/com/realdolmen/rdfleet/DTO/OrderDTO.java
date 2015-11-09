package com.realdolmen.rdfleet.DTO;

import com.realdolmen.rdfleet.entities.employee.Employee;

import java.util.List;

/**
 * Created by JDOAX80 on 5/11/2015.
 */
public class OrderDTO {
    private Long id;
    private CarTypeDTO carTypeDTO;
    private Employee employee;
    private List<CarOptionDTO> optionDTOList;


    public OrderDTO() {
    }

    public OrderDTO(CarTypeDTO carTypeDTO, Employee employee, List<CarOptionDTO> optionDTOList) {
        this.carTypeDTO = carTypeDTO;
        this.employee = employee;
        this.optionDTOList = optionDTOList;
    }

    public List<CarOptionDTO> getOptionDTOList() {
        return optionDTOList;
    }

    public void setOptionDTOList(List<CarOptionDTO> optionDTOList) {
        this.optionDTOList = optionDTOList;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public CarTypeDTO getCarTypeDTO() {
        return carTypeDTO;
    }

    public void setCarTypeDTO(CarTypeDTO carTypeDTO) {
        this.carTypeDTO = carTypeDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
