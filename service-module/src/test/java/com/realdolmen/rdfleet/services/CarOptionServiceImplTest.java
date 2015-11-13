package com.realdolmen.rdfleet.services;

import com.realdolmen.rdfleet.entities.car.options.CarOption;
import com.realdolmen.rdfleet.repositories.CarOptionRepository;
import com.realdolmen.rdfleet.services.implementations.CarOptionServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.io.Serializable;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by JDOAX80 on 4/11/2015.
 */
public class CarOptionServiceImplTest {
    private CarOptionRepository carOptionRepository;
    private CarOptionServiceImpl carOptionService;
    private CarOption carOption;

    @Before
    public void init() {
        carOptionRepository = mock(CarOptionRepository.class);
        carOptionService = new CarOptionServiceImpl(carOptionRepository);
        carOption = new CarOption("Option", 20);
    }

    @Test
    public void createCarOptionCanBeSuccessfullyCalledFromService() {
        carOptionService.createCarOption(carOption);
        verify(carOptionRepository).save(carOption);
    }

    @Test
    public void removeCarOptionCanBeSuccessfullyCalledFromService() {
        carOptionService.removeCarOption(carOption.getId());
        verify(carOptionRepository).delete(carOption.getId());
    }

    @Test
    public void findAllCarOptionsCanBeSuccessfullyCalledFromService() {
        when(carOptionRepository.findAll()).thenReturn(null);
        carOptionService.findAllCarOptions();
        verify(carOptionRepository).findAll();
    }

    @Test
    public void getCarOptionByIdCanBeCalledFromService() {
        carOptionService.getCarOptionById(1L);
        verify(carOptionRepository).findOne(1L);
    }
}
