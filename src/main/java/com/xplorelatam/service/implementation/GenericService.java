package com.xplorelatam.service.implementation;

import com.xplorelatam.repository.IGenericRepository;
import com.xplorelatam.service.IGenericService;

import java.util.List;

public abstract class GenericService<T,ID> implements IGenericService<T,ID> {
    protected abstract IGenericRepository<T,ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        // TODO Logica utilizando ID
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().deleteById(id);
    }
}
