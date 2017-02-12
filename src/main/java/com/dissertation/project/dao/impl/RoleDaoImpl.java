package com.dissertation.project.dao.impl;

import com.dissertation.project.dao.RoleDao;
import com.dissertation.project.model.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Andrei on 2/12/2017.
 */
@Repository
public class RoleDaoImpl implements RoleDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Role role){
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    public void remove(Role role){
        sessionFactory.getCurrentSession().delete(role);
    }
}
