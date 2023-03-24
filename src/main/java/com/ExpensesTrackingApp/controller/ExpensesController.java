package com.ExpensesTrackingApp.controller;

import com.ExpensesTrackingApp.Repository.ExpenseRepository;
import com.ExpensesTrackingApp.Repository.UserRepository;
import com.ExpensesTrackingApp.Service.CustomerService;
import com.ExpensesTrackingApp.Service.ExpenseService;
import com.ExpensesTrackingApp.models.Customer;
import com.ExpensesTrackingApp.models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// creating RestController
@RestController
public class ExpensesController {
    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    ExpenseService expenseService;
    @Autowired
    CustomerService customerService;
    @Autowired
     UserRepository userRepository;



    ExpensesController(ExpenseRepository expenseRepository){
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
    @DeleteMapping("/expense")
    public void deleteExpenseById(@RequestParam Integer id) {
        expenseService.deleteExpenseById(id);
    }

//    Update an expense by id
    @PostMapping("/expense")
    public Expense saveExpenseDetails(@RequestBody Expense expense) {
    return expenseService.saveExpenseDetails(expense);
}


//    @PostMapping("/customer/{customerId}/expenses")
//    public ResponseEntity<Expense> createExpense(@PathVariable(value="customerId") Long customerId,
//        @RequestBody Expense expenseRequest){
//        Expense expense = customerService.getCustomerById(customerId).map(customer -> {
//            expenseRequest.setCustomer(customer);
//            return expenseRepository.save(expenseRequest);
//        });
//        return new ResponseEntity<>(expense, HttpStatus.CREATED);
//    }




    }


