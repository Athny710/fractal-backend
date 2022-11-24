package com.example.fractal.controller;

import com.example.fractal.persistence.entity.CategoryEntity;
import com.example.fractal.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    // Obtener todas las categorías
    @GetMapping
    public ResponseEntity<List<CategoryEntity>> getAllCategory(){
        List<CategoryEntity> categoryList = this.categoryService.getAllCategory();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
}
