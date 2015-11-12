package com.realdolmen.rdfleet.repositories;

import com.realdolmen.rdfleet.entities.car.Car;
import com.realdolmen.rdfleet.entities.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by EWTAX45 on 28/10/2015.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findOneByEmail(String email);

    @Query("SELECT e FROM Employee e WHERE e.currentCar.endLeasing <= :date AND e.receivedMailForNewCar = false")//Sends an email 4 months in advance
    List<Employee> findAllEmployeesWhereCarLeasePeriodIsAboutToExpireAndWhereReceivedMailForNewCarIsFalse(@Param("date")LocalDate date);

    @Query("SELECT e FROM Employee e WHERE e.currentCar.endLeasing >= :date")
    List<Employee> findAllCarsWhereLeasingHasRunToAnEnd(@Param("date")LocalDate date);

    List<Employee> findAllByActive(boolean isActive);
}
