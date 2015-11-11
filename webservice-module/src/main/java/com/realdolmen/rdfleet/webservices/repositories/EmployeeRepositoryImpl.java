package com.realdolmen.rdfleet.webservices.repositories;

import com.realdolmen.rdfleet.entities.employee.Employee;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by JDOAX80 on 10/11/2015.
 */
@LocalBean
@Stateless
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Employee findEmployeeByEmail(String email) {
        List results = em.createQuery("SELECT e FROM Employee e WHERE e.email = :email").setParameter("email", email).getResultList();
        if (!results.isEmpty()) {
            return (Employee) results.get(0);
        } else {
            return null;
        }
    }
}
