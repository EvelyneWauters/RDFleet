package com.realdolmen.rdfleet.converters;

import com.realdolmen.rdfleet.converters.exceptions.CarModelConverterException;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import com.realdolmen.rdfleet.repositories.CarRepository;
import com.realdolmen.rdfleet.repositories.CarTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.convert.converters.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by EWTAX45 on 10/11/2015.
 */
@Component(value = "carTypeConverter")
public class CarTypeConverter implements Converter {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Class<?> getSourceClass() {
        return String.class;
    }

    @Override
    public Class<?> getTargetClass() {
        return CarType.class;
    }

    @Override
    public Object convertSourceToTargetClass(Object o, Class<?> aClass) throws Exception {
        if (o == null) {
            throw new CarModelConverterException("Can't convert null");
        }
        String idString = o.toString();
        long id = Long.parseLong(idString);
        return carRepository.findOne(id).getCarType();
    }
}
