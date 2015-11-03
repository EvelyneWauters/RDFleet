package com.realdolmen.rdfleet.repositories;


import com.realdolmen.rdfleet.entities.car.options.CarOption;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by JDOAX80 on 3/11/2015.
 */
public interface CarOptionRepository extends JpaRepository<CarOption, Long> {

}
