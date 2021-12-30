package com.nightowl.apis.controllers;

import com.nightowl.apis.models.entities.Category;
import com.nightowl.apis.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String  getAllCategories(){
        return "hello";
    }

    @PostMapping
    public void addCategory(@RequestBody Category category){
        System.out.println("hello");
        categoryService.addNewCategory(category);
    }
}
