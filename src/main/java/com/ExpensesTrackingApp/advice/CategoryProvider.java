package com.ExpensesTrackingApp.advice;

import com.ExpensesTrackingApp.Repository.CategoryRepository;
import com.ExpensesTrackingApp.models.Category;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class CategoryProvider {
    private final CategoryRepository categoryRepository;

    public CategoryProvider(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @ModelAttribute
    public List<String> categories(){
        return categoryRepository.findAll().stream().map(Category::getDescription).toList();
    }
}
