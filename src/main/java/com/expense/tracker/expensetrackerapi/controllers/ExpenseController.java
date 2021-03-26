package com.expense.tracker.expensetrackerapi.controllers;

import com.expense.tracker.expensetrackerapi.dao.ExpensiveExpenseDao;
import com.expense.tracker.expensetrackerapi.dtos.Expense;
import com.expense.tracker.expensetrackerapi.entities.ExpenseEntity;
import com.expense.tracker.expensetrackerapi.entities.ExpensiveEntity;
import com.expense.tracker.expensetrackerapi.repositories.ExpenseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/expense")
@CrossOrigin
public class ExpenseController {
    private final ExpenseRepository expenseRepository;
    private final ExpensiveExpenseDao expensiveExpenseDao;

    public ExpenseController(ExpenseRepository expenseRepository, ExpensiveExpenseDao expensiveExpenseDao) {
        this.expenseRepository = expenseRepository;
        this.expensiveExpenseDao = expensiveExpenseDao;
    }

    @PostMapping("/add")
    ResponseEntity<Expense> newExpense(@RequestBody Expense expense){

        Expense toReturn = Expense.fromEntity(expenseRepository.save(expense.toEntity()));
        return ResponseEntity.ok(toReturn);
    }

    @GetMapping
    ResponseEntity<List<Expense>> getAll(){
        List<ExpenseEntity> expenseEntityList = expenseRepository.findAll();
        List<Expense> expenseList = new ArrayList<>();
        expenseEntityList.forEach(expenseEntity -> expenseList.add(Expense.fromEntity(expenseEntity)));
        return ResponseEntity.ok(expenseList);
    }
    @GetMapping("/top/{UserId}")
    ResponseEntity<List<ExpensiveEntity>> getTopFiveAllTheTime(@PathVariable int UserId){
       return  ResponseEntity.ok(expensiveExpenseDao.getTopFiveAllTheTime(UserId));
    }
    @GetMapping("/top/{UserId}/{date}")
    ResponseEntity<List<ExpensiveEntity>> getTopFiveMonthly(@PathVariable int UserId, @PathVariable Date date){
       return  ResponseEntity.ok(expensiveExpenseDao.getTopFiveMonthly(UserId,date));
    }

}
