package com.hiringglobal.mobile.service;

import com.hiringglobal.mobile.config.RenderException;
import com.hiringglobal.mobile.model.Category;
import com.hiringglobal.mobile.repository.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private ICategoryRepository categoryRepository;
    private ValidateService validateService;

    public CategoryServiceImpl(ICategoryRepository categoryRepository, ValidateService validateService) {
        this.categoryRepository = categoryRepository;
        this.validateService = validateService;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int theId) {
        Optional<Category> result = categoryRepository.findById(theId);

        Category category = null;

        if(result.isPresent()) {
            category = result.get();
        }else{
            throw new RenderException("Id category not found ??? -> " + theId );
        }

        return category;
    }

    @Override
    public void save(Category category) {
        Category cate = categoryRepository.findByNameAndNameNotNull(category.getName());
        boolean isValid = validateService.validateString(category.getName());
        if(isValid){
            if(cate == null && category.getName() != null && category.getName() != ""){
                categoryRepository.save(category);
            }else{
                throw new RenderException("Category name already exits or not must be null !");
            }
        }else{
            throw new RenderException("Characters is wrong");
        }
    }

    @Override
    public void deleteById(int theId) {
        categoryRepository.deleteById(theId);
    }
}
