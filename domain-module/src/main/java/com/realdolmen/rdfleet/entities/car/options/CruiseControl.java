package com.realdolmen.rdfleet.entities.car.options;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by JDOAX80 on 2/11/2015.
 */
@Entity
@DiscriminatorValue(value = "cc")
public class CruiseControl extends CarOption {

    public CruiseControl() {
        super("Cruise Control", 50);
    }
 }
