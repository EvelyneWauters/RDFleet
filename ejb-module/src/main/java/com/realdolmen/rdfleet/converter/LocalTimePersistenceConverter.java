package com.realdolmen.rdfleet.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Time;
import java.time.LocalTime;

/**
 * Created by EWTAX45 on 11/10/2015.
 */
@Converter(autoApply = false)
public class LocalTimePersistenceConverter implements AttributeConverter<LocalTime, Time> {

    @Override
    public Time convertToDatabaseColumn(LocalTime entityValue) {
        return (entityValue == null) ? null : Time.valueOf(entityValue);
    }

    @Override
    public LocalTime convertToEntityAttribute(Time databaseValue) {
        return databaseValue.toLocalTime();
    }


}
