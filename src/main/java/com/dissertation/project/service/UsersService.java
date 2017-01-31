package com.dissertation.project.service;


import com.dissertation.project.jdbc.usersDBMapping.Users;

import java.io.Serializable;
import java.util.List;

public interface UsersService<T, D, ID extends Serializable>{

//    void create(Users user);

    Users findOne(ID id);

//    Users findByLogin(String login);

    List<Users> findAll();

    void save(D dto);

//    UserDao delete(long id);

}