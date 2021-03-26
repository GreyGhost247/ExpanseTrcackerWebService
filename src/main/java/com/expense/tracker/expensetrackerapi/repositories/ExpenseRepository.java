package com.expense.tracker.expensetrackerapi.repositories;

import com.expense.tracker.expensetrackerapi.entities.ExpenseEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ExpenseRepository extends JpaRepository<ExpenseEntity,Integer> {
    @Query("select SUM(ex.AMOUNT) from ExpenseEntity ex where ex.USERID = ?1")
    Double getTotalExpensesOfAllTheTime(int userId);


}
