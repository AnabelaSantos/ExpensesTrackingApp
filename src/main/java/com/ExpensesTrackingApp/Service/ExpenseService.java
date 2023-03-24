package com.ExpensesTrackingApp.Service;

import com.ExpensesTrackingApp.Repository.ExpenseRepository;
import com.ExpensesTrackingApp.Repository.UserRepository;
import com.ExpensesTrackingApp.models.Customer;
import com.ExpensesTrackingApp.models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    ExpenseRepository expenseRepository;

    //getting all expenses records
    public List<Expense> getAllExpense() {
        List<Expense> expenses = new ArrayList<Expense>();
        expenseRepository.findAll().forEach(expense -> expenses.add(expense));
        return expenses;
    }

    //getting a specific record
    public Expense getExpenseById(Integer id) {
        return expenseRepository.findById(id).get();
    }

    //getting the expenses by id
    public ResponseEntity<List<Expense>> getAllExpensesByCustomerId(@PathVariable(value = "customerId") Long customerId) {

        List<Expense> customerExpenses = expenseRepository.findByCustomerId(customerId);
        return new ResponseEntity<>(customerExpenses, HttpStatus.OK);
    }

    //deleting by id
    public void deleteExpenseById(Integer id) {
        expenseRepository.deleteById(id);
    }

    // saving expense

    public Expense saveExpenseDetails(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense save(Expense expenseRequest, Customer customer) {
        Expense _expense = new Expense();
        _expense.setAmount(expenseRequest.getAmount());
        _expense.setNote(expenseRequest.getNote());
        _expense.setStatus(expenseRequest.getStatus());
        _expense.setCustomer(customer);
        return expenseRepository.save(_expense);
    }
}








