package com.realdolmen.rdfleet.entities;

import com.realdolmen.rdfleet.Role;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Entity
public class User extends AbstractEntity {

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
        //Used by Hibernate
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
//    private String username;
//    private byte[] hashedPassword;
//
//    public User(String username, String password)
//    {
//        this.username = username;
//        this.hashedPassword = this.hashPassword(password);
//    }
//
//    public byte[] hashPassword(String password) {
//
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            md.update(password.getBytes("UTF-8")); // Change this to "UTF-16" if needed
//            return md.digest();
//        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public boolean checkPasswordIsValid(String password)
//    {
//        return getHashedPasswordAsString().equals(new String(this.hashPassword(password)));
//    }
//
//    public byte[] getHashedPassword() {
//        return hashedPassword;
//    }
//
//    public String getHashedPasswordAsString() {
//        return new String(hashedPassword);
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setHashedPassword(byte[] hashedPassword) {
//        this.hashedPassword = hashedPassword;
//    }


//}
//



