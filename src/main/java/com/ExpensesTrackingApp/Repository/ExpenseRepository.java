package com.ExpensesTrackingApp.Repository;

import com.ExpensesTrackingApp.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
List<Expense> findByCustomerId(Long customerId);

}
