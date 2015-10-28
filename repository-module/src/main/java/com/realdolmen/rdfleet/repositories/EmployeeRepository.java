package com.realdolmen.rdfleet.repositories;

import com.realdolmen.rdfleet.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by EWTAX45 on 28/10/2015.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
