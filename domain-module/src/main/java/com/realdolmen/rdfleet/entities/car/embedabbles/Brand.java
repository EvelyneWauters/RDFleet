package com.realdolmen.rdfleet.entities.car.embedabbles;

import com.realdolmen.rdfleet.entities.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by EWTAX45 on 28/10/2015.
 */

@Embeddable
public class Brand implements Serializable{

    @Column(nullable = false)
    private String name;

    public Brand() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
