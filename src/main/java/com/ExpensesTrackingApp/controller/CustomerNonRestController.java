package com.ExpensesTrackingApp.controller;

import com.ExpensesTrackingApp.Repository.CategoryRepository;
import com.ExpensesTrackingApp.Repository.CustomerRepository;
import com.ExpensesTrackingApp.Repository.ExpenseRepository;
import com.ExpensesTrackingApp.Service.ExpenseService;
import com.ExpensesTrackingApp.Service.UserRetrievalService;
import com.ExpensesTrackingApp.models.Category;
import com.ExpensesTrackingApp.models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerNonRestController {
    @Autowired
    public ExpenseService expenseService;
    @Autowired
    public UserRetrievalService userRetrievalService;
    @Autowired
    public CategoryRepository categoryRepository;
    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public ExpenseRepository expenseRepository;
    @GetMapping("expenseList")
    public String getAllExpensesForCustomer(Model model){
        Long currentUserID = userRetrievalService.getCurrentUserId();
        List<Expense> expenses = expenseService.getAllExpensesByCustomerId(currentUserID).getBody();
        List<String> categories = categoryRepository.findAll().stream().map(Category::getDescription).toList();
        model.addAttribute("expenses", expenses);
        model.addAttribute("categories", categories);
        return "expensesByCustomer";

    }
    @PostMapping("addNewExpense")
    public String addNewExpense(@RequestParam String category, @RequestParam float amount, @RequestParam boolean paid, Model model){
        Expense expense= new Expense();
        expense.setCategory(categoryRepository.findByDescription(category).get());
        expense.setAmount(amount);
        Long currentUserID = userRetrievalService.getCurrentUserId();
        expense.setCustomer(customerRepository.findById(currentUserID).get());
        expense.setStatus(paid);
        expenseRepository.save(expense);
        List<Expense> expenses = expenseService.getAllExpensesByCustomerId(currentUserID).getBody();
        List<String> categories = categoryRepository.findAll().stream().map(Category::getDescription).toList();
        model.addAttribute("expenses", expenses);
        model.addAttribute("categories", categories);

        return "expensesByCustomer";
    }

}
