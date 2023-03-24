package com.ExpensesTrackingApp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

// mark class as an Entity
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Expense {

    //mark id as primary key
    @Id
    //make it  as auto generated
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // defining id as column name
    @Column(name = "id")
    private Integer id;

    //defining amount as column name
    @Column(name = "Amount")
    private float amount;

    //defining note as column name
    @Column(name = "Note")
    private String note;

    //defining status as column name
    @Column(name = "Status")
    private boolean status;

    // need to add category and email (foreign keys)???
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
//    @JsonIgnoreProperties
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public Category category;


    public Expense(float amount, String note, boolean status, Category category) {
        this.amount = amount;
        this.note = note;
        this.status = status;
        this.category = category;
    }

    public Expense(float amount, String note, Category category) {
        this.amount = amount;
        this.note = note;
        this.category = category;
    }

    public Expense(float amount, Category category) {
        this.amount = amount;
        this.category = category;
    }

    public Expense(Category category){

        this.category = category;
    }
    public Expense(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
