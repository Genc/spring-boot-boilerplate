package com.hiringglobal.mobile.service;

import java.util.List;

public interface IGeneralService<T,U> {
    List<T> findAll();

    T findById(U id);

    void update(T t);

    void remove(U id);
}
