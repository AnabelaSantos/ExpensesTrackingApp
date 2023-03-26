package com.ExpensesTrackingApp.controller;

import com.ExpensesTrackingApp.Repository.CategoryRepository;
import com.ExpensesTrackingApp.Service.CategoryService;
import com.ExpensesTrackingApp.models.Category;
import com.ExpensesTrackingApp.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/category/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") Integer id) {
        categoryRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // creating a post mapping that adds a new category
    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category _category = categoryService.createCategory(category);
        return new ResponseEntity<>(_category, HttpStatus.CREATED);
    }


}
