package com.ExpensesTrackingApp.models;

import java.util.List;

public class PaidExpenses {
    private List<Expense> expenses;
    private double total;

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
