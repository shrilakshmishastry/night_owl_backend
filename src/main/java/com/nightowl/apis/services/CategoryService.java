package com.nightowl.apis.services;

import com.nightowl.apis.models.entities.Category;
import com.nightowl.apis.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addNewCategory(Category category) {
        Optional<Category> categoryOptional = categoryRepository.findCategoryByName(category.getName());
        if(categoryOptional.isPresent()){

            throw new IllegalStateException("Already there");
        }
        categoryRepository.save(category);
    }
}
