package com.realdolmen.rdfleet.webservices.repositories;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.webservices.repositories.CarRepository;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by JDOAX80 on 10/11/2015.
 */
@LocalBean
@Stateless
public class CarRepositoryImpl implements CarRepository {
    @PersistenceContext
    private EntityManager em;


    @Override
    public void saveCar(Car car) {
        em.persist(car);
    }
}
