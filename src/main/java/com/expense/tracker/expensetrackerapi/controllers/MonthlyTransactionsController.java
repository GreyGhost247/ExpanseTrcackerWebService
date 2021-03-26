package com.expense.tracker.expensetrackerapi.controllers;

import com.expense.tracker.expensetrackerapi.dao.MonthlyTransactionsDao;
import com.expense.tracker.expensetrackerapi.entities.MonthlyTransactions;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@RestController
@RequestMapping("/monthly")
@CrossOrigin
public class MonthlyTransactionsController {
    private final MonthlyTransactionsDao monthlyTransactionsDao;

    public MonthlyTransactionsController(MonthlyTransactionsDao monthlyTransactionsDao) {
        this.monthlyTransactionsDao = monthlyTransactionsDao;
    }
    @GetMapping("/{USERID}/{start}/{end}")
    Map<LocalDate, List<MonthlyTransactions>> getMonthlyTransactions(@PathVariable int USERID, @PathVariable Date start,
                                                                     @PathVariable Date end){
        List<MonthlyTransactions> incomeTransactions = monthlyTransactionsDao.getMonthlyIncomeTransactions(USERID,start,end);
        List<MonthlyTransactions> expenseTransactions = monthlyTransactionsDao.getMonthlyExpenseTransactions(USERID,start,end);
        List<MonthlyTransactions> combinedList = Stream.concat(incomeTransactions.stream(), expenseTransactions.stream())
                .collect(Collectors.toList());

        Map<LocalDate, List<MonthlyTransactions>> byMonth = combinedList.stream()
                .collect(groupingBy(MonthlyTransactions::getYR));

        return new TreeMap<>(byMonth);

    }
}
