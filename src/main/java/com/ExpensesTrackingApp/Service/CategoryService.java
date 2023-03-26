package com.ExpensesTrackingApp.Service;

import com.ExpensesTrackingApp.Repository.CategoryRepository;
import com.ExpensesTrackingApp.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    //getting all category records
    public List<Category> getAllCategory()
    {
        return categoryRepository.findAll();
    }

    //getting a specific record
    public Category getCategoryById(Integer id){
        return categoryRepository.findById(id).get();
    }
    //saving or updating a specific record
    public void saveOrUpdate(Category category){
        categoryRepository.save(category);
    }
    //deleting a specific record
    public void deleteById(Integer id){
        categoryRepository.deleteById(id);
    }

    //Creating a new category
    public Category createCategory(Category category){
        Category _category = categoryRepository.save(new Category(category.getDescription()));
        return _category;
    }
}


