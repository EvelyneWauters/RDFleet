package com.realdolmen.rdfleet;

import com.realdolmen.rdfleet.entities.User;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by JDOAX80 on 28/10/2015.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }

}