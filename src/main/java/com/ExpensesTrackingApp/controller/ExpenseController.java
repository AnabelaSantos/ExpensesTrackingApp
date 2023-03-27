package com.ExpensesTrackingApp.controller;

import com.ExpensesTrackingApp.Repository.CategoryRepository;
import com.ExpensesTrackingApp.Repository.ExpenseRepository;
import com.ExpensesTrackingApp.Repository.CustomerRepository;
import com.ExpensesTrackingApp.Service.CategoryService;
import com.ExpensesTrackingApp.Service.CustomerService;
import com.ExpensesTrackingApp.Service.ExpenseService;
import com.ExpensesTrackingApp.models.Category;
import com.ExpensesTrackingApp.models.Customer;
import com.ExpensesTrackingApp.models.Expense;
import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// creating RestController
@RestController
public class ExpenseController {
    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    ExpenseService expenseService;
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryService categoryService;


    ExpenseController(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    @GetMapping("/expense")
    List<Expense> all(){
        return expenseRepository.findAll();
    }

    @GetMapping("/expense/{id}")
    public Expense getExpense(@PathVariable("id")Integer id){

        return expenseService.getExpenseById(id);
    }

    @GetMapping("/customer/{customerId}/expenses")
    public ResponseEntity<List<Expense>> getAllExpensesByCustomerId(@PathVariable(value="customerId") Long customerId){

    List<Expense> customerExpenses = expenseRepository.findByCustomerId(customerId);
    return new ResponseEntity<>(customerExpenses, HttpStatus.OK);
    }

    //deleting one expense by id
    @DeleteMapping("/expense/{id}")
    public ResponseEntity<HttpStatus> deleteExpenseById(@PathVariable("id") Integer id) {
        expenseRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


//    @PostMapping("/expense")
//    public Expense saveExpenseDetails(@RequestBody Expense expense) {
//    return expenseService.saveExpenseDetails(expense);
//}

//    Update an expense by customer id
    @PostMapping("/customer/{customerId}/expenses")
    public ResponseEntity<Expense> createExpense(@PathVariable(value = "customerId") Long customerId,
                                                 @RequestBody Expense expenseRequest) {
        Expense expense = customerRepository.findById(customerId).map(customer -> {
            expenseRequest.setCustomer(customer);
            return expenseRepository.save(expenseRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found Customer with id = " + customerId));

        return new ResponseEntity<>(expense, HttpStatus.CREATED);
    }

    //Add new expense with category
    @PostMapping("/customer/{customerId}/category/{categoryId}/expenses")
    public ResponseEntity<Expense> createExpenseWithCategory(@PathVariable(value = "customerId") Long customerId,
                                                             @PathVariable(value = "categoryId") Integer categoryId,
                                                 @RequestBody Expense expenseRequest) {

        Expense expense = customerRepository.findById(customerId).map(customer -> {
            expenseRequest.setCustomer(customer);
            categoryRepository.findById(categoryId).map(category -> {expenseRequest.setCategory(category);
                return expenseRepository.save(expenseRequest);
            });
            return expenseRepository.save(expenseRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found Customer with id = " + customerId));

        return new ResponseEntity<>(expense, HttpStatus.CREATED);
    }


    @PostMapping("/expenses")
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
        Expense _expense = expenseService.save(expense);

        return new ResponseEntity<>(_expense, HttpStatus.OK);
    }

    //get a list of paid expenses by id
    @GetMapping("customer/{customerId}/expenses/paid")
    public ResponseEntity<List<Expense>> findByStatus(@PathVariable(value="customerId") Long customerId) {
        List<Expense> expenses = expenseService.findByStatus(true, customerId);

        if (expenses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    //get a list of unpaid expenses by id
    @GetMapping("customer/{customerId}/expenses/unpaid")
    public ResponseEntity<List<Expense>> findByStatusUnpaid(@PathVariable(value="customerId") Long customerId) {
        List<Expense> expenses = expenseService.findByStatus(false, customerId);

        if (expenses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    //delete all expenses of a customer id
    @DeleteMapping("/customer/{customerId}/expenses")
    public ResponseEntity<List<Expense>> deleteAllExpensesOfCustomer(@PathVariable(value = "customerId") Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new ResourceNotFoundException("Not found Customer with id = " + customerId);
        }
        expenseRepository.deleteByCustomerId(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}


