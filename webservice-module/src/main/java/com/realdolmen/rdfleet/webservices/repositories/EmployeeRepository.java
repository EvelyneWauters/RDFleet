package com.realdolmen.rdfleet.webservices.repositories;

import com.realdolmen.rdfleet.entities.employee.Employee;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by JDOAX80 on 10/11/2015.
 */
@Remote
public interface EmployeeRepository {
    Employee findEmployeeByEmail(String email);
}
