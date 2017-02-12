package com.dissertation.project.service.impl;

import com.dissertation.project.dao.UserDao;
import com.dissertation.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Andrei on 2/12/2017.
 */
public class UserServiceImpl implements UserDao{

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public User find(User user){
        return userDao.find(user);
    }

    @Override
    @Transactional
    public List findAll(){
        return userDao.findAll();
    }

    @Override
    @Transactional
    public User findById(String id){
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public User findByLogin(String login){
        return userDao.findByLogin(login);
    }

    @Override
    @Transactional
    public void remove(User user) {
        userDao.remove(user);
    }

    @Override
    @Transactional
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDao.update(user);
    }
}
