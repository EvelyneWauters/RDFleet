package com.realdolmen.rdfleet.entities.car.options;

//import com.realdolmen.rdfleet.entities.car.CarComponent;

import com.realdolmen.rdfleet.entities.AbstractEntity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

/**
 * Created by JDOAX80 on 2/11/2015.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "car_option")
public class CarOption extends AbstractEntity{

    @NotNull
    private String optionName;
    private double price;

    public CarOption() {
    }

    public CarOption(String optionName, double price) {
        this.optionName = optionName;
        this.price = price;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
