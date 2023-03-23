package com.ExpensesTrackingApp.Service;

import com.ExpensesTrackingApp.Repository.UserRepository;
import com.ExpensesTrackingApp.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CustomerService {
    @Autowired
    UserRepository userRepository;

    //getting all customers records
    public List<Customer> getAllCustomer()
    {
       return userRepository.findAll();
    }

    //getting a specific record

    public Customer getCustomerById(Long id){
        return userRepository.findById(id).get();
    }
    //saving or updating a specific record
    public void saveOrUpdate(Customer customer){
        userRepository.save(customer);
    }
    //deleting a specific record
    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
