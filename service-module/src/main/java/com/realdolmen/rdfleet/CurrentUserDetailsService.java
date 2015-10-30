package com.realdolmen.rdfleet;

import com.realdolmen.rdfleet.entities.Employee;
import com.realdolmen.rdfleet.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
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
        Employee employee = employeeService.getUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)));
        return new CurrentUser(employee);
    }
}