package com.ExpensesTrackingApp.Service;

import com.ExpensesTrackingApp.Repository.ExpenseRepository;
import com.ExpensesTrackingApp.Repository.UserRepository;
import com.ExpensesTrackingApp.models.Customer;
import com.ExpensesTrackingApp.models.Expense;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ExpenseService {
    @Autowired
    ExpenseRepository expenseRepository;

    //getting all expenses records
    public List<Expense> getAllExpense()
    {
        List<Expense> expenses = new ArrayList<Expense>();
        expenseRepository.findAll().forEach(expense->expenses.add(expense));
        return expenses;
    }
}
