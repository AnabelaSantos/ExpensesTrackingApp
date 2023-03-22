package com.ExpensesTrackingApp.controller;


import com.ExpensesTrackingApp.Repository.UserRepository;
import com.ExpensesTrackingApp.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// creating RestController
@RestController
public class CustomerController {
    //autowired the Expense class
    @Autowired
    UserRepository userRepository;

    @GetMapping("/customer")
    private List<Customer> getAllUser() {
        return userRepository.findAll();
        }

}

