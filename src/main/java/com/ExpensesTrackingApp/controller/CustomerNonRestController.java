package com.ExpensesTrackingApp.controller;

import com.ExpensesTrackingApp.Service.ExpenseService;
import com.ExpensesTrackingApp.Service.UserRetrievalService;
import com.ExpensesTrackingApp.models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerNonRestController {
    @Autowired
    public ExpenseService expenseService;
    @Autowired
    public UserRetrievalService userRetrievalService;


    @GetMapping("expenseList")
    public String getAllExpensesForCustomer(Model model){
        Long currentUserID = userRetrievalService.getCurrentUserId();
        List<Expense> expenses = expenseService.getAllExpensesByCustomerId(currentUserID).getBody();
        model.addAttribute("expenses", expenses);
        return "expensesByCustomer";



    }
}
