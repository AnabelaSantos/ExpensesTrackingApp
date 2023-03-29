package com.ExpensesTrackingApp.controller;


import com.ExpensesTrackingApp.Repository.CustomerRepository;
import com.ExpensesTrackingApp.Service.CustomerService;
import com.ExpensesTrackingApp.models.Customer;
import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// creating RestController
@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerService customerService;

//creating a get mapping that retrieves a list with all customers' details
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/customer")
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
        }

//creating a get mapping that retrieves a detail of a specific customer
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable("id")Long id){
        return customerService.getCustomerById(id);
    }


    // creating a post mapping that adds a new customer
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer _customer = customerService.createCustomer(customer);
        return new ResponseEntity<>(_customer, HttpStatus.CREATED);
    }

    //deleting a customer
    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") long id) {
        customerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
//update customer
    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
        Customer _customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Customer with id = " + id));

        _customer.setEmail(customer.getEmail());
        _customer.setUsername(customer.getUsername());


        return new ResponseEntity<>(customerRepository.save(_customer), HttpStatus.OK);
    }




}

