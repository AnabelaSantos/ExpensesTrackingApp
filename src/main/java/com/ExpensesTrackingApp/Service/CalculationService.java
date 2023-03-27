package com.ExpensesTrackingApp.Service;

import com.ExpensesTrackingApp.models.Expense;
import org.springframework.stereotype.Service;

import java.util.List;

public class CalculationService {
    public static double calculateTotalAmount(List<Expense> expenses){
        double total = 0;
        for(Expense expense:expenses){
            total = total+expense.getAmount();
        }
        return total;
    }
}
