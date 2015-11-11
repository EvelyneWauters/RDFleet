package com.realdolmen.rdfleet.services;

import com.realdolmen.rdfleet.services.DTO.CarTypeDTO;
import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.car.CarType;
import com.realdolmen.rdfleet.entities.car.embedabbles.Brand;
import com.realdolmen.rdfleet.entities.car.embedabbles.CarModel;
import com.realdolmen.rdfleet.repositories.CarTypeRepository;
import com.realdolmen.rdfleet.services.implementations.CarTypeServiceImpl;
import com.realdolmen.rdfleet.services.mappers.CarTypeMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Sort;

import javax.validation.ConstraintViolationException;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by JDOAX80 on 2/11/2015.
 */
public class CarTypeServiceImplTest extends ServicesTest {

    private CarTypeServiceImpl carTypeService;
    private CarTypeRepository carTypeRepository;
    private Car car;

    @Before
    public void init() {
        carTypeRepository = Mockito.mock(CarTypeRepository.class);
        carTypeService = new CarTypeServiceImpl(carTypeRepository);
        createNewCar();
    }

    @Test
    public void createOrUpdateCarTypeCanBeCalledFromService() {
        CarTypeDTO cartypeDTO = new CarTypeDTO();
        when(CarTypeMapper.mapCarTypeDTOToCarTypeObject(cartypeDTO, car.getCarType())).thenReturn(car.getCarType());
        carTypeService.createCarType(cartypeDTO);
        verify(carTypeRepository).save(car.getCarType());
    }


    @Test
    public void findAllAvailableCarTypesCanBeCalledFromService() {
        List<CarType> types = new ArrayList<>();
        types.add(car.getCarType());
        when(carTypeRepository.findAllByIsAvailableTrue()).thenReturn(types);
        when(CarTypeMapper.mapCarTypeObjectToCarTypeDTO(any(CarType.class))).thenReturn(null);
        carTypeService.findAllAvailableCarTypes();
        verify(carTypeRepository).findAllByIsAvailableTrue();
        verify(CarTypeMapper.mapCarTypeObjectToCarTypeDTO(any(CarType.class)));
    }

    @Test
    public void findByIdCanBeCalledFromService() {
        carTypeService.findById(car.getId());
        verify(carTypeRepository).findOne(car.getId());
    }

    @Test
    public void findAllCarTypesCanBeCalledFromService() {
        carTypeService.findAllCarTypes();
        verify(carTypeRepository).findAll();
    }

    @Test
    public void removeCarTypeFromListCanBeCalledFromService() {
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
