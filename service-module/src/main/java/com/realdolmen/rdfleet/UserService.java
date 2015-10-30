package com.realdolmen.rdfleet;

import com.realdolmen.rdfleet.DTO.UserDTO;
import com.realdolmen.rdfleet.entities.User;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by JDOAX80 on 28/10/2015.
 */
public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserDTO userDTO);

}
