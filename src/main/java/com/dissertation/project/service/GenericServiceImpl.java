package com.dissertation.project.service;//package com.dissertation.project.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class GenericServiceImpl<T, D, ID extends Serializable> implements GenericService<T, D, ID> {

    @Autowired
    private JpaRepository<T, ID> repository;

    @Autowired
    private DozerBeanMapper mapper;

    protected Class<T> entityClass;

    protected Class<D> dtoClass;

    @SuppressWarnings("unchecked")
    public GenericServiceImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
        this.dtoClass = (Class<D>) genericSuperclass.getActualTypeArguments()[1];
    }

    public D findOne(ID id) {
        return mapper.map(repository.findOne(id), dtoClass);
    }

    public List<D> findAll() {
        List<D> result = new ArrayList<D>();
        for (T t : repository.findAll()) {
            result.add(mapper.map(t, dtoClass));
        }
        return result;
    }

    public void save(D dto) {
        repository.saveAndFlush(mapper.map(dto, entityClass));
    }

    @Override
    public void saveOrUpdate(T entity) {

    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public T get(D id) {
        return null;
    }

    @Override
    public void add(T entity) {

    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void remove(T entity) {

    }
}
//
//import com.dissertation.project.jdbc.GenericDao;
//import com.dissertation.project.service.GenericService;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//public abstract class GenericServiceImpl<E, K> implements GenericService<E, K> {
//
//    private GenericDao<E, K> genericDao;
//
//    public GenericServiceImpl(GenericDao<E, K> genericDao) {
//        this.genericDao = genericDao;
//    }
//
//    public GenericServiceImpl() {
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void saveOrUpdate(E entity) {
//        genericDao.saveOrUpdate(entity);
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
//    public List<E> getAll() {
//        return genericDao.getAll();
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
//    public E get(K id) {
//        return genericDao.find(id);
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void add(E entity) {
//        genericDao.add(entity);
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void update(E entity) {
//        genericDao.update(entity);
//    }
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void remove(E entity) {
//        genericDao.remove(entity);
//    }
//}