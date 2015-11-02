package com.realdolmen.rdfleet.entities.car;

import com.realdolmen.rdfleet.entities.AbstractEntity;

/**
 * Created by JDOAX80 on 2/11/2015.
 */
public abstract class CarComponent extends AbstractEntity {
    String description = "Unknown Car Component";

    public String getDescription() {
        return description;
    }

    public abstract double cost();


}
