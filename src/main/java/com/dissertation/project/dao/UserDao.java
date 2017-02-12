package com.dissertation.project.dao;

import com.dissertation.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao {
    User find(User user);
    void remove(User user);
    void create(User user);
    void update(User user);
    List findAll();
    User findById(String id);
    User findByLogin(String login);
}
