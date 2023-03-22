package com.ExpensesTrackingApp.controller;

import Repository.CategoryRepository;
import Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class ExpensesController {
    @Autowired
    ExpenseRepository expenseRepository;
    CategoryRepository categoryRepository;


}
