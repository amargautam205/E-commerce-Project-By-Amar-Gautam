package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    public CategoryRepository categoryRepository;


    public void addCategory(Category category) {
        this.categoryRepository.save(category);
    }

    public List<Category> getAllCategory(){
        return this.categoryRepository.findAll();

    }

    public void deleteById(int id) {
        this.categoryRepository.deleteById(id);
    }

    public Optional<Category> updateById(int id){
        return this.categoryRepository.findById(id);
    }

}
