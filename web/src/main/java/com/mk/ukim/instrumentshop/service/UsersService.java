package com.mk.ukim.instrumentshop.service;

import com.mk.ukim.instrumentshop.model.Users;
import com.mk.ukim.instrumentshop.model.enumerations.Role;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    Optional<Users> findByUsername(String user_username);
    Users findById(Integer user_id);
    List<Users> listAll();
    Users register(Integer user_id, String user_username, String user_password, String user_email, String user_name, Role role);

}

