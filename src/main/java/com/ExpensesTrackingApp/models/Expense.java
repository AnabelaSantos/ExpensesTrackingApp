package com.ExpensesTrackingApp.models;

import jakarta.persistence.*;

// mark class as an Entity
@Entity

//defining class name as Table name
@Table

public class Expense {

    //mark id as primary key
    @Id
    //make it  as auto generated
    @GeneratedValue(strategy = GenerationType.AUTO)
    // defining id as column name
    @Column(name = "id")
    private int id;

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
    @JoinColumn(name="email")
    private User user;

    @ManyToOne
    @JoinColumn(name="category_id")
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
