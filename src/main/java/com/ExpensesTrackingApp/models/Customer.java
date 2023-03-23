package com.ExpensesTrackingApp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

// mark class as an Entity
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {
    // mark email as primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    //defining email as column name
    @Column(name = "email")
    private String email;

    //defining username as column name
    @Column(name = "username")
    private String username;

    //defining expenses as column name

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Expense> expenses = new ArrayList<>();

    public Customer(String username, String email, List<Expense> expenses){
        this.username = username;
        this.email = email;
        this.expenses = expenses;
    }

    public Customer(String username, String email){
        this.username = username;
        this.email = email;
    }

    public Customer(){
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
