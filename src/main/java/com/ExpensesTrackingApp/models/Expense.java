package com.ExpensesTrackingApp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Optional;

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
    //validation minimum amount of 1
    @Min(1)
    private float amount;

    //defining Note as column name
    @Column(name = "Note")
    //validation minimum of 3 and maximum of 200 chars. if not is empty send message
    @NotEmpty(message = "Please enter expense details")
    @Size(min=3, max=200)
    private String note;

    //defining status as column name
    @Column(name = "Status")
    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
//    @JsonIgnoreProperties
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    public Category category;


    public Expense(int id, float amount, String note, boolean status, Category category) {
        this.id = id;
        this.amount = amount;
        this.note = note;
        this.status = status;
        this.category = category;
    }

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

    public boolean isStatus() {
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
