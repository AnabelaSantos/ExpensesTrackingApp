package com.ExpensesTrackingApp.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;

    private String email;

    private List<Expense> expenses = new ArrayList<>();

    public User(String username, String email, List<Expense> expenses){
        this.username = username;
        this.email = email;
        this.expenses = expenses;
    }

    public User(String username, String email){
        this.username = username;
        this.email = email;
    }

    public User(){
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
