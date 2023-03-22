package com.ExpensesTrackingApp.models;

import jakarta.persistence.*;

// mark class as an Entity
@Entity
public class Expense {

    //mark id as primary key
    @Id
    //make it  as auto generated
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // defining id as column name
    @Column(name = "id")
    private Integer id;

    //defining amount as column name
    @Column(name = "amount")
    private float amount;

    //defining note as column name
    @Column(name = "note")
    private String note;

    //defining status as column name
    @Column(name = "status")
    private boolean status;

    // need to add category and email (foreign keys)???
    @ManyToOne
    private Customer customer;

    @ManyToOne
    public Category category;


    public Expense(int id, float amount, String note, boolean status, Category category) {
        this.id = id;
        this.amount = amount;
        this.note = note;
        this.status = status;
        this.category = category;
    }

    public Expense(int id, float amount, String note, Category category) {
        this.id = id;
        this.amount = amount;
        this.note = note;
        this.category = category;
    }

    public Expense(int id, float amount, Category category) {
        this.id = id;
        this.amount = amount;
        this.category = category;
    }

    public Expense(Category category){

        this.category = category;
    }
    public Expense(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public Customer getUser() {
        return customer;
    }

    public void setUser(Customer customer) {
        this.customer = customer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
