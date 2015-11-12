package com.realdolmen.rdfleet.services.implementations;

import com.realdolmen.rdfleet.entities.Order;
import com.realdolmen.rdfleet.entities.car.options.CarOption;
import com.realdolmen.rdfleet.repositories.OrderRepository;
import com.realdolmen.rdfleet.services.DTO.CarDTO;
import com.realdolmen.rdfleet.services.DTO.EmployeeDTO;
import com.realdolmen.rdfleet.services.DTO.OrderDTO;
import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.repositories.CarRepository;
import com.realdolmen.rdfleet.repositories.EmployeeRepository;
import com.realdolmen.rdfleet.services.definitions.EmployeeService;
import com.realdolmen.rdfleet.services.mappers.CarMapper;
import com.realdolmen.rdfleet.services.mappers.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

import static com.realdolmen.rdfleet.services.mappers.EmployeeMapper.mapEmployeeToEmployeeDtoObject;

/**
 * Created by JDOAX80 on 28/10/2015.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO getEmployeeById(long id) {
        Optional<Employee> employee = Optional.ofNullable(employeeRepository.findOne(id));
        if (employee.isPresent()) {
            return mapEmployeeToEmployeeDtoObject(employee.get());
        } else {
            throw new IllegalArgumentException("there is no employee found with id " + id);
        }
    }

    @Override
    public EmployeeDTO getEmployeeDtoByEmail(String email) {
        Optional<Employee> employee = employeeRepository.findOneByEmail(email);
        if (employee.isPresent()) {
            return mapEmployeeToEmployeeDtoObject(employee.get());
        } else {
            throw new IllegalArgumentException("there is no employee found with email ' " + email + " '.");
        }
    }


    @Override
    public Optional<Employee> getOptionalEmployeeByEmail(String email) {
        return employeeRepository.findOneByEmail(email);
    }

    @Override
    public Collection<EmployeeDTO> getAllEmployees() {
//        List<Employee> employeeList = employeeRepository.findAll(new Sort("email"));
//        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
//        for (Employee employee : employeeList) {
//            employeeDTOList.add(mapEmployeeToEmployeeDtoObject(employee));
//        }
//        return employeeDTOList;
        return mapEmployeeListToEmployeeDTOList(employeeRepository.findAll(new Sort("email")));
    }

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmail(employeeDTO.getEmail());
        employee.setPasswordHash(hashPassword(employeeDTO.getPassword()));
        employee.setRole(employeeDTO.getRole());
        return employeeRepository.save(employee);
    }

    @Override
    public String hashPassword(String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public CarDTO assignCarToEmployee(Order order, int leasingDurationInYears, String numberPlate, String vinNumber) {
        Employee employee = order.getEmployee();
        if(employee.getCurrentCar() != null) {
            moveCurrentCarToCarHistory(employee);
        }

        Car car = createNewCarFromOrder(order, leasingDurationInYears, numberPlate, vinNumber);

        employee.setCurrentCar(car);

        employeeRepository.save(employee);
        return CarMapper.mapCarObjectToCarDTO(car);
    }

    private Car createNewCarFromOrder(Order order, int leasingDurationInYears, String numberPlate, String vinNumber) {
        Car car = new Car();
        car.setCarType(order.getCarType());

        if(order.getOptions().size() > 1) {
            List<CarOption> optionList = order.getOptions();
            car.setCarOptions(optionList);
        }

        car.setLeasingDurationYears(leasingDurationInYears);
        car.setNumberPlate(numberPlate);
        car.setStartLeasing(LocalDate.now());
        car.setVinNumber(vinNumber);

        orderRepository.delete(order);
        carRepository.save(car);
        return car;
    }

    private void moveCurrentCarToCarHistory(Employee employee) {
        Car currentCar = carRepository.findOne(employee.getCurrentCar().getId());
        Set<Car> carHistory = employee.getCarHistory();
        carHistory.add(employee.getCurrentCar());

        if(currentCar.getEndLeasing().isAfter(LocalDate.now()) && !(currentCar.getEndLeasing().isEqual(LocalDate.now()))) {
            currentCar.setInThePool(true);
        }
        carRepository.save(currentCar);
    }

    @Override
    public CarDTO assignPoolCarToEmployee(EmployeeDTO employeeDTO, CarDTO carDTO) {
        Employee employee = employeeRepository.findOneByEmail(employeeDTO.getEmail()).get();

        updatePoolCar(carRepository.findOne(carDTO.getId()));
        Car currentCar = employee.getCurrentCar();

        if (currentCar != null) {
            Set<Car> carHistory = employee.getCarHistory();
            currentCar.setEndLeasing(LocalDate.now());
            carHistory.add(currentCar);
        }
        employee.setCurrentCar(carRepository.findOne(carDTO.getId()));
        employeeRepository.save(employee);
        return carDTO;
    }

    @Override
    public List<EmployeeDTO> getAllEmployeesByActive(boolean isActive) {
        return mapEmployeeListToEmployeeDTOList(employeeRepository.findAllByActive(isActive));
    }

    private List<EmployeeDTO> mapEmployeeListToEmployeeDTOList(List<Employee> employees) {
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        employees.forEach(employee -> {
            employeeDTOs.add(EmployeeMapper.mapEmployeeToEmployeeDtoObject(employee));
        });
        return employeeDTOs;
    }

    public void updatePoolCar(Car car)  {
        car.setInThePool(false);
        car.setStartLeasing(LocalDate.now());
        carRepository.save(car);
    }


    public void updateEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findOneByEmail(employeeDTO.getEmail()).get();
        if (checkIfValidEntity(employee)) {
            employee.setFunctionalLevel(employeeDTO.getFunctionalLevel());
            employee.setActive(employeeDTO.getActive());
            employeeRepository.save(employee);
        }
    }


    public boolean checkIfValidEntity(Employee employee) {
        int functionalLevel = employee.getFunctionalLevel();
        if (functionalLevel < 1 || functionalLevel > 7)
            throw new IllegalArgumentException("The functional level can not be lower than 1 or higher than 7!");
        return true;
    }
}
