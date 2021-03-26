package com.expense.tracker.expensetrackerapi.dtos;

import com.expense.tracker.expensetrackerapi.entities.ExpenseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Expense {
    private int expenseId;
    private int userId;
    private int categoryId;
    private double amount;
    private Date logDate;
    @JsonIgnore
    public ExpenseEntity toEntity(){
        ExpenseEntity expenseEntity = new ExpenseEntity();
        expenseEntity.setUSERID(getUserId());
        expenseEntity.setCATEGORYID(getCategoryId());
        expenseEntity.setAMOUNT(getAmount());
        expenseEntity.setLOGDATE(getLogDate());
        return expenseEntity;
    }

    public static Expense fromEntity(ExpenseEntity expenseEntity){
        Expense expense = new Expense();
        expense.setExpenseId(expenseEntity.getId());
        expense.setUserId(expenseEntity.getUSERID());
        expense.setCategoryId(expenseEntity.getCATEGORYID());
        expense.setAmount(expenseEntity.getAMOUNT());
        expense.setLogDate(expenseEntity.getLOGDATE());
        return expense;
    }
}
