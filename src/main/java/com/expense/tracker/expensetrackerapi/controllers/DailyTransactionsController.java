package com.expense.tracker.expensetrackerapi.controllers;

import com.expense.tracker.expensetrackerapi.dao.DailyTransactionsDao;
import com.expense.tracker.expensetrackerapi.entities.DailyTransactions;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@RestController
@RequestMapping("/daily")
@CrossOrigin
public class DailyTransactionsController {

    private final DailyTransactionsDao dailyTransactionsDao;


    public DailyTransactionsController(DailyTransactionsDao dailyTransactionsDao) {
        this.dailyTransactionsDao = dailyTransactionsDao;
    }


    @GetMapping("/{USERID}/{date}")
    Map<LocalDate, List<DailyTransactions>> getDailyTransactions(@PathVariable int USERID, @PathVariable Date date){
        List<DailyTransactions> incomeTransactions = dailyTransactionsDao.getDailyIncomeSummed(USERID,date);
        List<DailyTransactions> expenseTransactions = dailyTransactionsDao.getDailyExpenseSummed(USERID,date);
        List<DailyTransactions> combinedList = Stream.concat(incomeTransactions.stream(), expenseTransactions.stream())
                .collect(Collectors.toList());

        Map<LocalDate, List<DailyTransactions>> byDay = combinedList.stream()
                .collect(groupingBy(DailyTransactions::getLOG_DATE));

        /*for(  Map.Entry<LocalDate, List<DailyTransactions>> e : byDay.entrySet()){
            for(DailyTransactions e1 : e.getValue())
                System.out.println(e.getKey() + " = "+ e1.getDAILY_TRANSACTION()+" type:"+e1.getT_TYPE());
        }*/
        return new TreeMap<LocalDate, List<DailyTransactions>>(byDay);

    }

}
