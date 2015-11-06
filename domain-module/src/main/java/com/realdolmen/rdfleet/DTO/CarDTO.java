package com.realdolmen.rdfleet.DTO;

import com.realdolmen.rdfleet.converter.LocalDatePersistenceConverter;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.options.CarOption;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JDOAX80 on 5/11/2015.
 */
public class CarDTO {

    @NotNull
    private CarType carType;
    @NotNull
    private String vinNumber;
    @NotNull
    private LocalDate startLeasing;
    @Convert(converter = LocalDatePersistenceConverter.class)
    private LocalDate endLeasing;
    private int leasingDurationYears = 4;
    private double mileage;
    private int amountOfRefuels;
    @NotNull
    private String numberPlate;
    private List<CarOption> carOptions = new ArrayList<>();


}
