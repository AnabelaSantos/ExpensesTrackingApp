package com.ExpensesTrackingApp.controller;


import Repository.UserRepository;
import com.ExpensesTrackingApp.models.Category;
import com.ExpensesTrackingApp.models.Expense;
import com.ExpensesTrackingApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;


// creating RestController
@RestController
public class UserController {
    //autowired the Expense class
    @Autowired
    UserRepository userRepository;
    Expense expense;
    private Category category;

    //creating a get mapping that retrieves all the users detail from the DB
    @GetMapping("/user")
    //private List<User> getAllUser() {
     public User giveMeAUser(){
            List<Expense> expenses = new ArrayList<>();
            expenses.add(new Expense(category));
            User user1 = new User("Jon", "jon@email.com", expenses);
            return user1;
        }
}

