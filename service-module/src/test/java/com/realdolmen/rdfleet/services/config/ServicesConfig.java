package com.realdolmen.rdfleet.services.config;

import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.repositories.CarRepository;
import com.realdolmen.rdfleet.repositories.CarTypeRepository;
import com.realdolmen.rdfleet.repositories.EmployeeRepository;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by JDOAX80 on 2/11/2015.
 */
@Configuration
@Profile("test")
public class ServicesConfig {

}
