package com.ExpensesTrackingApp.controller;

import com.ExpensesTrackingApp.Repository.CategoryRepository;
import com.ExpensesTrackingApp.Service.CategoryService;
import com.ExpensesTrackingApp.models.Category;
import com.ExpensesTrackingApp.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryService categoryService;
    @GetMapping("/category")
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable("id")Integer id){
        return categoryService.getCategoryById(id);
    }


}
