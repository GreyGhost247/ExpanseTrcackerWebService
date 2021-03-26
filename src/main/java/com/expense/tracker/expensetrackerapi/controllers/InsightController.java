package com.expense.tracker.expensetrackerapi.controllers;

import com.expense.tracker.expensetrackerapi.dao.InsightDao;
import com.expense.tracker.expensetrackerapi.entities.Insight;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("insight")
@CrossOrigin
public class InsightController {
    private final InsightDao insightDao;

    public InsightController(InsightDao insightDao) {
        this.insightDao = insightDao;
    }

      @GetMapping("/{USERID}/{date}")
      ResponseEntity<Insight> getUserExpenseTransactions(@PathVariable int USERID, @PathVariable Date date) {

        return ResponseEntity.ok(insightDao.getInsight(USERID,date).get(0));

    }
}
