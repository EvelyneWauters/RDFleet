package com.realdolmen.rdfleet.services.implementations;

import com.realdolmen.rdfleet.entities.employee.CurrentUser;
import com.realdolmen.rdfleet.entities.employee.Employee;
import com.realdolmen.rdfleet.entities.employee.User;
import com.realdolmen.rdfleet.services.definitions.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by JDOAX80 on 28/10/2015.
 */
@Service
public class CurrentUserDetailsService implements UserDetailsService {

    private final EmployeeService employeeService;

    @Autowired
    public CurrentUserDetailsService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee employee = employeeService.getOptionalEmployeeByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)));
        return new CurrentUser(employee);
    }

    public CurrentUser getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof CurrentUser) {
            return (CurrentUser) principal;
        }
        else {
            return null;
        }
    }

    public boolean getEmployeeCanOrder() {
        return getCurrentUser().getUser().getReceivedMailForNewCar();
    }
}