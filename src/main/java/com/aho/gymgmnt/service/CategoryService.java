package com.aho.gymgmnt.service;

import com.aho.gymgmnt.dao.CategoryDao;
import com.aho.gymgmnt.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<Category> findAll(){
        return categoryDao.findAll();
    }

    public Optional<Category> findOneById(int id){
        return categoryDao.findById(id);
    }

    public void deleteById(int id) {
        categoryDao.deleteById(id); }

    public Category add(Category category) {
        return categoryDao.save(category);
    }

    public Category update(int id, Category category){
        return categoryDao.save(category);
    }


}
