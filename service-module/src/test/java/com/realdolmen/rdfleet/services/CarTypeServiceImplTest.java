package com.realdolmen.rdfleet.services;

import com.realdolmen.rdfleet.services.DTO.CarDTO;
import com.realdolmen.rdfleet.services.DTO.CarTypeDTO;
import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import com.realdolmen.rdfleet.repositories.CarTypeRepository;
import com.realdolmen.rdfleet.services.definitions.CarTypeService;
import com.realdolmen.rdfleet.services.implementations.CarTypeServiceImpl;
import com.realdolmen.rdfleet.services.mappers.CarTypeMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

/**
 * Created by JDOAX80 on 2/11/2015.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(CarTypeMapper.class)
public class CarTypeServiceImplTest {

    private CarTypeServiceImpl carTypeService;
    private CarTypeRepository carTypeRepository;
    private Car car;

    @Before
    public void init() {
        PowerMockito.mockStatic(CarTypeMapper.class);
        carTypeRepository = Mockito.mock(CarTypeRepository.class);
        carTypeService = new CarTypeServiceImpl(carTypeRepository);
        createNewCar();
    }

    @Test
    public void findAllCarTypesCanBeSuccessfullyCalledFromService() {
        carTypeService.findAllCarTypes();
        verify(carTypeRepository).findAll();
    }

    @Test
    public void findCarByFunctionalLevelCanBeSuccessfullyCalledFromService() {
        List<CarType> types = new ArrayList<>();
        types.add(car.getCarType());
        when(carTypeRepository.findCarTypeByCategoryAndIsAvailableTrue(1)).thenReturn(types);
        when(CarTypeMapper.mapCarTypeObjectToCarTypeDTO(new CarType())).thenReturn(null);
        carTypeService.findCarByFunctionalLevel(1);
        verify(carTypeRepository).findCarTypeByCategoryAndIsAvailableTrue(1);
    }

    @Test
    public void findAllAvailableCarTypesCanBeSuccessfullyCalledFromService() {
        List<CarType> types = new ArrayList<>();
        types.add(car.getCarType());
        CarTypeServiceImpl carTypeServiceSpy = spy(carTypeService);
        when(carTypeRepository.findAllByIsAvailableTrue()).thenReturn(types);
        when(CarTypeMapper.mapCarTypeObjectToCarTypeDTO(new CarType())).thenReturn(null);
        when(carTypeServiceSpy.mapEntityListToDTOList(types)).thenReturn(null);
        carTypeService.findAllAvailableCarTypes();
        verify(carTypeRepository).findAllByIsAvailableTrue();
        verifyStatic();
        CarTypeMapper.mapCarTypeObjectToCarTypeDTO(any(CarType.class));
    }

    @Test
    public void findByIdCanBeSuccessfullyCalledFromService() {
        carTypeService.findById(car.getId());
        verify(carTypeRepository).findOne(anyLong());
    }

    @Test
    //TODO:fix test!
    public void createCarTypeCanBeSuccessfullyCalledFromService() {
        CarType carType = new CarType();
        carType.setCategory(5);
        CarTypeServiceImpl carTypeServiceSpy = spy(carTypeService);
        when(CarTypeMapper.mapCarTypeDTOToCarTypeObject(any(CarTypeDTO.class), any(CarType.class))).thenReturn(carType);
        CarTypeDTO cartypeDTO = new CarTypeDTO();
        carTypeService.createCarType(cartypeDTO);
        doReturn(true).when(carTypeServiceSpy).checkIfValidEntity(carType);
//        when(carTypeServiceSpy.checkIfValidEntity(carType)).thenReturn(true);
        verify(carTypeRepository).save(carType);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ifInvalidEntityThrowIllegalArgumentException() {
        CarType carType = new CarType();
        carType.setCategory(8);
        carTypeService.checkIfValidEntity(carType);
    }

    @Test
    public void updateExistingCarTypeCanBeSuccessfullyCalledFromService() {
        when(carTypeRepository.findOne(1L)).thenReturn(new CarType());
        carTypeService.updateExistingCarType(1L, new CarTypeDTO());
        verify(carTypeRepository).save(any(CarType.class));
    }

    @Test
    public void removeCarTypeFromListCanBeSuccessfullyCalledFromService() {
        when(carTypeRepository.findOne(car.getId())).thenReturn(car.getCarType());
        carTypeService.removeCarTypeFromList(car.getId());
        verify(carTypeRepository).findOne(car.getId());
        verify(carTypeRepository).save(car.getCarType());
    }


//    @Test(expected = ConstraintViolationException.class)
//    public void carTypeCantBeCreatedWithoutCategoryLevel() {
//        carType.setCarModel(carModel);
//        carTypeRepository.save(carType);
//    }
//
//    @Test(expected = ConstraintViolationException.class)
//    public void carTypeCantBeCreatedWithCategoryLevelSmallerThanOne() {
//        carType.setCarModel(carModel);
//        carType.setCategory(0);
//        carTypeRepository.save(carType);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void carTypeCantBeCreatedWithCategoryLevelHigherThanSeven() {
//        carType.setCarModel(carModel);
//        carType.setCategory(8);
//        carTypeRepository.save(carType);
//    }

    public void createNewCar() {
        car = new Car();
        CarModel carModel = new CarModel();
        carModel.setModelName("A6");
        Brand brand = new Brand();
        brand.setName("Audi");
        CarType carType = new CarType();
        carType.setCarModel(carModel);
        carType.setBrand(brand);
        car.setCarType(carType);
    }
}
