package com.ExpensesTrackingApp.controller;

import com.ExpensesTrackingApp.Repository.CategoryRepository;
import com.ExpensesTrackingApp.Repository.ExpenseRepository;
import com.ExpensesTrackingApp.Repository.CustomerRepository;
import com.ExpensesTrackingApp.Service.CalculationService;
import com.ExpensesTrackingApp.Service.CategoryService;
import com.ExpensesTrackingApp.Service.CustomerService;
import com.ExpensesTrackingApp.Service.ExpenseService;
import com.ExpensesTrackingApp.models.Category;
import com.ExpensesTrackingApp.models.Customer;
import com.ExpensesTrackingApp.models.Expense;
import com.ExpensesTrackingApp.models.PaidExpenses;
import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/expense")
    List<Expense> all(){
        return expenseRepository.findAll();
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/expense/{id}")
    public Expense getExpense(@PathVariable("id")Integer id){

        return expenseService.getExpenseById(id);
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/customer/{customerId}/expenses")
    public ResponseEntity<List<Expense>> getAllExpensesByCustomerId(@PathVariable(value="customerId") Long customerId){

    List<Expense> customerExpenses = expenseRepository.findByCustomerId(customerId);
    return new ResponseEntity<>(customerExpenses, HttpStatus.OK);
    }

    //deleting one expense by id
    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/expense/{id}")
    public ResponseEntity<HttpStatus> deleteExpenseById(@PathVariable("id") Integer id) {
        expenseRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


//    Update an expense by customer id
    @CrossOrigin(origins = "http://localhost:8080")
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
    @CrossOrigin(origins = "http://localhost:8080")
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

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/expenses")
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
        Expense _expense = expenseService.save(expense);

        return new ResponseEntity<>(_expense, HttpStatus.OK);
    }

    //get a list of paid expenses by id
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("customer/{customerId}/expenses/paid")
    public ResponseEntity<PaidExpenses> findByStatus(@PathVariable(value="customerId") Long customerId) {
        List<Expense> expenses = expenseService.findByStatus(true, customerId);
        double total = CalculationService.calculateTotalAmount(expenses);

        if (expenses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        PaidExpenses paidExpenses = new PaidExpenses();
        paidExpenses.setExpenses(expenses);
        paidExpenses.setTotal(total);

        return new ResponseEntity<>(paidExpenses, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("customer/{customerId}/expenses/byCategory")
    public Map<String, Double> totalByCategory(@PathVariable(value="customerId") Long customerId) {
        List<Expense> expenses = expenseService.getAllExpensesByCustomerId(customerId).getBody();

        return expenses.stream().collect(Collectors.groupingBy(expense -> expense.getCategory().getDescription(), Collectors.summingDouble(Expense::getAmount)));
    }

    //update an expense by id
    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping("/expense/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable("id") Integer id, @RequestBody Expense expense) {
        Expense _expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Expense with id = " + id));

        _expense.setAmount(expense.getAmount());
        _expense.setNote(expense.getNote());
        _expense.setStatus(expense.isStatus());


        return new ResponseEntity<>(expenseRepository.save(_expense), HttpStatus.OK);
    }

    //get a list of unpaid expenses by id
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("customer/{customerId}/expenses/unpaid")
    public ResponseEntity<List<Expense>> findByStatusUnpaid(@PathVariable(value="customerId") Long customerId) {
        List<Expense> expenses = expenseService.findByStatus(false, customerId);

        if (expenses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    //delete all expenses of a customer id
    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/customer/{customerId}/expenses")
    public ResponseEntity<List<Expense>> deleteAllExpensesOfCustomer(@PathVariable(value = "customerId") Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new ResourceNotFoundException("Not found Customer with id = " + customerId);
        }
        expenseRepository.deleteByCustomerId(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}


