package com.realdolmen.rdfleet.repositories;

import com.realdolmen.rdfleet.entities.Order;
import com.realdolmen.rdfleet.entities.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by JDOAX80 on 4/11/2015.
 */
public interface OrderRepository extends JpaRepository<Order, Long>, OrderRepositoryInterface {
}
