package com.realdolmen.rdfleet.converters;

import com.realdolmen.rdfleet.DTO.OrderDTO;
import com.realdolmen.rdfleet.converters.exceptions.CarModelConverterException;
import com.realdolmen.rdfleet.entities.Order;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import com.realdolmen.rdfleet.repositories.CarTypeRepository;
import com.realdolmen.rdfleet.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.convert.converters.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by EWTAX45 on 9/11/2015.
 */
@Component(value = "orderConverter")
public class OrderConverter implements Converter{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Class<?> getSourceClass() {
        return String.class;
    }

    @Override
    public Class<?> getTargetClass() {
        return Order.class;
    }

    @Override
    public Object convertSourceToTargetClass(Object o, Class<?> aClass) throws Exception {
        if (o == null) {
            throw new CarModelConverterException("Can't convert null");
        }
        String idString = o.toString();
        long id = Long.parseLong(idString);
        return orderRepository.findOne(id);
    }
}
