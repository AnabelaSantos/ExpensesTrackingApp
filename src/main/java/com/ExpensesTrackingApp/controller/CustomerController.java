package com.ExpensesTrackingApp.controller;


import com.ExpensesTrackingApp.Repository.UserRepository;
import com.ExpensesTrackingApp.Service.CustomerService;
import com.ExpensesTrackingApp.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    private List<Customer> getAllCustomer() {
        return userRepository.findAll();
        }

//creating a get mapping that retrieves a detail of a specific customer
//    @GetMapping("/customer/{id}")
//    private Customer getCustomer(@PathVariable("id")Long id){
//        return customerService.getCustomerById(id);
//    }




}

