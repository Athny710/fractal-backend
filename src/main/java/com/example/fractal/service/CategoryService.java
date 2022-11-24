package com.example.fractal.service;

import com.example.fractal.persistence.entity.CategoryEntity;
import com.example.fractal.persistence.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    // Otener todas las categorías existentes
    public List<CategoryEntity> getAllCategory(){
        return this.categoryRepository.findAll();
    }
}
