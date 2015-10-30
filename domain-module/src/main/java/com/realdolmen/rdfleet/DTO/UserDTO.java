package com.realdolmen.rdfleet.DTO;

import com.realdolmen.rdfleet.Role;
import com.realdolmen.rdfleet.entities.User;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by JDOAX80 on 28/10/2015.
 */
public class UserDTO {

    @NotEmpty
    private String email = "";

    @NotEmpty
    private String password = "";

    @NotNull
    private Role role = Role.USER;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
