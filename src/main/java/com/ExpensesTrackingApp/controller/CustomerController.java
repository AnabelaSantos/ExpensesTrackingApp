package com.ExpensesTrackingApp.controller;


import com.ExpensesTrackingApp.Repository.UserRepository;
import com.ExpensesTrackingApp.Service.CustomerService;
import com.ExpensesTrackingApp.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// creating RestController
@RestController
public class CustomerController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CustomerService customerService;

//creating a get mapping that retrieves a list with all customers' details
    @GetMapping("/customer")
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
        }

//creating a get mapping that retrieves a detail of a specific customer
    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable("id")Long id){
        return customerService.getCustomerById(id);
    }
// creating a post mapping that adds a new customer
    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer _customer = userRepository.save(new Customer(customer.getEmail(), customer.getUsername()));
        return new ResponseEntity<>(_customer, HttpStatus.CREATED);
    }



}

