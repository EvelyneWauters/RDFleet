package com.realdolmen.rdfleet.converters;

import com.realdolmen.rdfleet.converters.exceptions.CarModelConverterException;
import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.repositories.CarTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.convert.converters.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by EWTAX45 on 6/11/2015.
 */
@Component(value = "brandConverter")
public class BrandConverter implements Converter {

    @Autowired
    private CarTypeRepository carTypeRepository;

    @Override
    public Class<?> getSourceClass() {
        return String.class;
    }

    @Override
    public Class<?> getTargetClass() {
        return Brand.class;
    }

    @Override
    public Object convertSourceToTargetClass(Object o, Class<?> aClass) throws Exception {
        if (o == null) {
            throw new CarModelConverterException("Can't convert null");
        }
        String idString = o.toString();
        long id = Long.parseLong(idString);
        return carTypeRepository.findOne(id).getBrand();
    }
}
