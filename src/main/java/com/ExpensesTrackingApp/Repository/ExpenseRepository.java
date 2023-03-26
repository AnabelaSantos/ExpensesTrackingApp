package com.ExpensesTrackingApp.Repository;

import com.ExpensesTrackingApp.models.Expense;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
List<Expense> findByCustomerId(Long customerId);
@Transactional
List<Expense> findByStatusAndCustomerId(boolean status, Long customerId);

@Transactional
    void deleteByCustomerId(Long customerId);

}
