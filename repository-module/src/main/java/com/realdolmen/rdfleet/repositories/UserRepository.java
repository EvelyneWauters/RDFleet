package com.realdolmen.rdfleet.repositories;

import com.realdolmen.rdfleet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by JDOAX80 on 28/10/2015.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByEmail(String email);
}
