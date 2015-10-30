package com.realdolmen.rdfleet.entities.employee;

import com.realdolmen.rdfleet.entities.employee.enums.Role;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by JDOAX80 on 28/10/2015.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private Employee employee;

    public CurrentUser(Employee employee) {
        super(employee.getEmail(), employee.getPasswordHash(), AuthorityUtils.createAuthorityList(employee.getRole().toString()));
        this.employee = employee;
    }

    public User getUser() {
        return employee;
    }

    public Long getId() {
        return employee.getId();
    }

    public Role getRole() {
        return employee.getRole();
    }

}