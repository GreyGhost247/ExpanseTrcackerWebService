package com.expense.tracker.expensetrackerapi.controllers;

import com.expense.tracker.expensetrackerapi.dao.MonthlyAverageDao;
import com.expense.tracker.expensetrackerapi.dao.YearlyAverageDao;
import com.expense.tracker.expensetrackerapi.entities.MonthlyAverage;
import com.expense.tracker.expensetrackerapi.entities.YearlyAverage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/average")
@CrossOrigin
public class AverageController {
    private final MonthlyAverageDao monthlyAverageDao;
    private final YearlyAverageDao yearlyAverageDao;

    public AverageController(MonthlyAverageDao monthlyAverageDao, YearlyAverageDao yearlyAverageDao) {
        this.monthlyAverageDao = monthlyAverageDao;
        this.yearlyAverageDao = yearlyAverageDao;
    }

     @GetMapping("/{catId}/{date}/{userId}")
    ResponseEntity<MonthlyAverage> getMonthlyAverage(@PathVariable int catId, @PathVariable Date date,
                                                           @PathVariable int userId) {

        return ResponseEntity.ok(monthlyAverageDao.getMonthlyAverage(catId,date,userId).get(0));

    }

    @GetMapping("/{catId}/{userId}")
    ResponseEntity<YearlyAverage> getYearlyAverage(@PathVariable int catId, @PathVariable int userId) {

        return ResponseEntity.ok(yearlyAverageDao.getYearlyAverage(catId,userId).get(0));

    }
}
