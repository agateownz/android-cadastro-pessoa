package com.agateownz.testapplication.data;

import java.util.List;

/**
 * Created by luisg on 04/03/2018.
 */

public interface IRepository<T, ID> {

    void saveOrUpdate(T object);

    void delete(T object);

    T getById(ID id);

    List<T> getAll();
}
