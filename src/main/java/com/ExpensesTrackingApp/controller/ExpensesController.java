package com.ExpensesTrackingApp.controller;

import com.ExpensesTrackingApp.Repository.ExpenseRepository;
import com.ExpensesTrackingApp.Repository.UserRepository;
import com.ExpensesTrackingApp.models.Customer;
import com.ExpensesTrackingApp.models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// creating RestController
@RestController
public class ExpensesController {
    @Autowired
    ExpenseRepository expenseRepository;

    ExpensesController(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    @GetMapping("/expense")
    List<Expense> all(){
        return expenseRepository.findAll();
    }
//    private List<Expense> getAllExpenses() {
//        return expenseRepository.findAll();
//    }

}
