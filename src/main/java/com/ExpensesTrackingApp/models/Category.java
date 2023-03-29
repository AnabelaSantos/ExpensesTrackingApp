package com.ExpensesTrackingApp.models;

import jakarta.persistence.*;


//mark class as entity
@Entity
public class Category {

    //mark id as primary key
    @Id
    //make it  as auto generated
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //defining id as column name
    @Column(name = "id")
    private Integer id;

    //defining description as column name
    @Column(name = "description")
    private String description;


    public Category(String description) {
        this.description = description;
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

}
