package com.dissertation.project.dao.impl;

import com.dissertation.project.dao.UserDao;
import com.dissertation.project.model.User;
import org.hibernate.SessionFactory;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Andrei on 2/12/2017.
 */
@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(User user){
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void remove(User user){
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public void update(User user){
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User find(User user){
        sessionFactory.getCurrentSession().contains(user);
        return user;
    }

    @Override
    public List findAll(){
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    @Override
    public User findById(String id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User findByLogin(String login) {
        return (User) sessionFactory.getCurrentSession().get(User.class, login);
    }
}
