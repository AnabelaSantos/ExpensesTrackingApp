package com.ExpensesTrackingApp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

//mark class as entity
@Entity

//defining class name as Table name
@Table

public class Category {

    //mark id as primary key
    @Id

    //defining id as column name
    @Column
    private int id;

    //defining description as column name
    @Column
    private String description;

    private List<Expense> expenses = new ArrayList<>();

    public Category(int id, String description, List<Expense> expenses) {
        this.id = id;
        this.description = description;
        this.expenses = expenses;
    }

    public Category(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Category(int id) {
        this.id = id;
    }

    public  Category(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
