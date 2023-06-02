package com.ExpensesTrackingApp.Service;

import com.ExpensesTrackingApp.models.Customer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service


public class UserRetrievalService {
    public Long getCurrentUserId(){
        return ((Customer) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal())
                .getId();
    }
}
