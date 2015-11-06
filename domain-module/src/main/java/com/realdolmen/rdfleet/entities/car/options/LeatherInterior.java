package com.realdolmen.rdfleet.entities.car.options;

import com.realdolmen.rdfleet.entities.car.options.enums.LeatherType;

import javax.persistence.*;

/**
 * Created by JDOAX80 on 2/11/2015.
 */
@Entity
@DiscriminatorValue(value = "li")
public class LeatherInterior extends CarOption {

    @Enumerated(EnumType.STRING)
    @Column(name = "leatherType")
    private LeatherType leatherType = LeatherType.IMITATION;

    public LeatherInterior(LeatherType leatherType) {
        super("Leather Interior", 50);
        this.leatherType = leatherType;
    }

    public LeatherType getLeatherType() {
        return leatherType;
    }

    public void setLeatherType(LeatherType leatherType) {
        this.leatherType = leatherType;
    }
}
