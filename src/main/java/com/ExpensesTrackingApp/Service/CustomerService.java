package com.ExpensesTrackingApp.Service;

import com.ExpensesTrackingApp.Repository.ExpenseRepository;
import com.ExpensesTrackingApp.Repository.CustomerRepository;
import com.ExpensesTrackingApp.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ExpenseRepository expenseRepository;

    //getting all customers records
    public List<Customer> getAllCustomer()
    {
       return customerRepository.findAll();
    }

    //getting a specific record
    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).get();
    }
    //Creating a new customer
    public Customer createCustomer(Customer customer){
        Customer _customer = customerRepository.save(new Customer(customer.getEmail(), customer.getUsername()));
        return _customer;
    }
    //deleting a specific record
    public void deleteById(Long id){
        customerRepository.deleteById(id);
    }

}