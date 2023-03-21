package com.ExpensesTrackingApp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// mark class as an Entity
@Entity

//defining class name as Table name
@Table

public class Expense {

    //mark id as primary key
    @Id

    // defining id as column name
    @Column
    private int id;

    //defining amount as column name
    @Column
    private float amount;

    //defining note as column name
    @Column
    private String note;

    //defining status as column name
    @Column
    private boolean status;

    // need to add category and email (foreign keys)???



    public Expense(int id, float amount, String note, boolean status) {
        this.id = id;
        this.amount = amount;
        this.note = note;
        this.status = status;
    }

    public Expense(int id, float amount, String note) {
        this.id = id;
        this.amount = amount;
        this.note = note;
    }

    public Expense(int id, float amount) {
        this.id = id;
        this.amount = amount;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
