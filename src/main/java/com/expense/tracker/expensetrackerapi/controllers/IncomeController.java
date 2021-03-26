package com.expense.tracker.expensetrackerapi.controllers;

import com.expense.tracker.expensetrackerapi.dao.BarChartDetailsDao;
import com.expense.tracker.expensetrackerapi.dtos.Income;
import com.expense.tracker.expensetrackerapi.entities.BarChartDetails;
import com.expense.tracker.expensetrackerapi.entities.IncomeEntity;
import com.expense.tracker.expensetrackerapi.repositories.IncomeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/income")
@CrossOrigin
public class IncomeController {
    private final IncomeRepository incomeRepository;
    private final BarChartDetailsDao barChartDetailsDao;



    public IncomeController(IncomeRepository incomeRepository, BarChartDetailsDao barChartDetailsDao) { this.incomeRepository = incomeRepository;
        this.barChartDetailsDao = barChartDetailsDao;
    }

    @PostMapping("/add")
    ResponseEntity<Income> newIncome(@RequestBody Income income){

        Income toReturn = Income.fromEntity(incomeRepository.save(income.toEntity()));
        return ResponseEntity.ok(toReturn);
    }
    @GetMapping
    ResponseEntity<List<Income>> getAll(){
        List<IncomeEntity> incomeEntityList = incomeRepository.findAll();
        List<Income> incomeList = new ArrayList<>();
        incomeEntityList.forEach(incomeEntity -> incomeList.add(Income.fromEntity(incomeEntity)));
        return ResponseEntity.ok(incomeList);
    }

    @GetMapping("/details/i/{date}/{userId}")
    ResponseEntity<List<BarChartDetails>> getBarDetails(@PathVariable Date date, @PathVariable int userId){
       return ResponseEntity.ok(barChartDetailsDao.getIncomeChartDetails(userId,date));
    }

    @GetMapping("/details/e/{date}/{userId}")
    ResponseEntity<List<BarChartDetails>> getExpenseBarDetails(@PathVariable Date date, @PathVariable int userId){
        return ResponseEntity.ok(barChartDetailsDao.getExpenseChartDetails(userId,date));
    }

}
