package com.ExpensesTrackingApp.controllers;


import com.ExpensesTrackingApp.models.Expense;
import com.ExpensesTrackingApp.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
public class UserController {
    @GetMapping("giveMeAUser")
        public User giveMeAUser(){
            List<Expense> expenses = new ArrayList<>();
            expenses.add(new Expense());
            User user1 = new User("Jon", "jon@email.com", expenses);
            return user1;
        }
}

