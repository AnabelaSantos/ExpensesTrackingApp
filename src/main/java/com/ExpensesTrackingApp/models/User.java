package com.ExpensesTrackingApp.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

// mark class as an Entity
@Entity

// defining class name as Table name

@Table

public class User {
    // mark email as primary key
    @Id
    //defining email as column name
    @Column(name = "email")
    private String email;

    //defining username as column name
    @Column(name = "username")
    private String username;

    //defining expenses as column name

    @OneToMany(mappedBy = "user")
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

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
