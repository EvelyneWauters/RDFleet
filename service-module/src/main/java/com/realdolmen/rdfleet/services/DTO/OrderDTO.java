package com.realdolmen.rdfleet.services.DTO;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.options.CarOption;
import com.realdolmen.rdfleet.entities.employee.Employee;

import java.io.Serializable;
import java.util.List;

/**
 * Created by JDOAX80 on 5/11/2015.
 */
public class OrderDTO extends AbstractDTO {
    private CarType carType;
    private Employee employee;
    private List<CarOption> optionList;


    public OrderDTO() {
    }

    public OrderDTO(CarType carType, Employee employee, List<CarOption> optionList) {
        this.carType = carType;
        this.employee = employee;
        this.optionList = optionList;
    }

    public List<CarOption> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<CarOption> optionList) {
        this.optionList = optionList;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    
}
