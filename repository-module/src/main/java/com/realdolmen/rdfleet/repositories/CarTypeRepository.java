package com.realdolmen.rdfleet.repositories;

import com.realdolmen.rdfleet.entities.car.CarType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by EWTAX45 on 28/10/2015.
 */
@Repository
public interface CarTypeRepository extends JpaRepository<CarType, Long>{
    List<CarType> findCarTypeByCategory(int i);
    List<CarType> findAllByIsAvailableTrue();
}
