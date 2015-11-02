package com.realdolmen.rdfleet.entities.car.options;

import com.realdolmen.rdfleet.entities.car.CarComponent;

/**
 * Created by JDOAX80 on 2/11/2015.
 */
public class LeatherInterior extends CarOption {
    private CarComponent carComponent;
    private final double PRICE = 50;

    public LeatherInterior(CarComponent carComponent) {
        this.carComponent = carComponent;
    }

    @Override
    public String getDescription() {
        return carComponent.getDescription() + ", leather interior";
    }

    @Override
    public double cost() {
        return PRICE + carComponent.cost();
    }
}
