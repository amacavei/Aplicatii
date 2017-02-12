package com.dissertation.project.service.impl;

import com.dissertation.project.dao.RoleDao;
import com.dissertation.project.model.Role;
import com.dissertation.project.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Andrei on 2/12/2017.
 */
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional
    public void create(Role role) {
        roleDao.create(role);
    }

    @Override
    @Transactional
    public void remove(Role role) {
        roleDao.remove(role);
    }
}
