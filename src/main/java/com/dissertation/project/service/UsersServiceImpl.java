package com.dissertation.project.service;

import com.dissertation.project.jdbc.usersDBMapping.Users;
import com.dissertation.project.service.dto.UserDto;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public abstract class UsersServiceImpl<T, D, ID extends Serializable> implements UsersService<T, D, ID> {


    @Autowired
    private JpaRepository<Users, ID> repository;

    @Autowired
    private DozerBeanMapper mapper;

    @Autowired
    protected Users users;

    @Autowired
    private UserDto userDto;

 //   @Autowired
//    public UsersServiceImpl(
//            @Qualifier("adminDaoImpl") GenericDao<Users, Integer> genericDao) {
//        super(genericDao);
//        this.usersDao = (UsersDao) genericDao;
//    }

    @SuppressWarnings("unchecked")
    public UsersServiceImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        userDto = (UserDto) pt.getActualTypeArguments()[0];
    }

//    @Override
//    public void create(Users user) {
//        usersDao.create(user);
//    }
//
//    @Override
//    public Users getUser(long id) {
//        return usersDao.getUser(id);
//    }
//
//    @Override
//    public Users findByLogin(String login) {
//        return usersDao.findByLogin(login);
//    }

    @Override
    public Users findOne(ID id) {
        return mapper.map(repository.findOne(id), Users.class);
    }


////    @Override
////    public Users findByLogin(String login) {
////        return mapper.map(Users.findByLogin(login), Users.class);
////    }

    @Override
    public List<Users> findAll() {
        List<Users> result = new ArrayList<Users>();
        for (Users user : repository.findAll()) {
            result.add(mapper.map(user, Users.class));
        }
        return result;
    }

    @Override
    public void save(D dto) {
        repository.saveAndFlush(mapper.map(dto, Users.class));
    }

//    @Override
//    public UserDao delete(long id){
//        Users delete = findOne(id);
//        repository.delete(delete);
//        mapper.map(delete, Users.class);
//    }

}