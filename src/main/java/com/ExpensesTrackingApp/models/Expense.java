package com.ExpensesTrackingApp.models;

public class Expense {

    private int id;

    private float amount;

    private String note;

    // need to add category???

    private boolean status;



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
