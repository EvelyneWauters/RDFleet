package com.realdolmen.rdfleet.entities.car.options;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by JDOAX80 on 2/11/2015.
 */
@Entity
@DiscriminatorValue(value = "hc")
public class HeatedSeats extends CarOption {

    public HeatedSeats() {
        super("Heated Seats", 50);
    }
}
