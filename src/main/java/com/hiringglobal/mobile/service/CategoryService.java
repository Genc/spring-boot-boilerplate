package com.hiringglobal.mobile.service;

import com.hiringglobal.mobile.model.Category;

import java.util.List;


public interface CategoryService {

    List<Category> findAll();

    Category findById(int theId);

    void save(Category category);

    void deleteById(int theId);

}
