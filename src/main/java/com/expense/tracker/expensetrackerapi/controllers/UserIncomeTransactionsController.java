package com.expense.tracker.expensetrackerapi.controllers;

import com.expense.tracker.expensetrackerapi.dao.UserExpenseTransactionsDao;
import com.expense.tracker.expensetrackerapi.dao.UserIncomeTransactionsDao;
import com.expense.tracker.expensetrackerapi.entities.UserTransactions;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/transactions")
@CrossOrigin(origins = "http://localhost:4200")
public class UserIncomeTransactionsController {
    private final UserIncomeTransactionsDao userIncomeTransactionsDao;
    private final UserExpenseTransactionsDao userExpenseTransactionsDao;

    public UserIncomeTransactionsController(UserIncomeTransactionsDao userIncomeTransactionsDao, UserExpenseTransactionsDao userExpenseTransactionsDao) {
        this.userIncomeTransactionsDao = userIncomeTransactionsDao;
        this.userExpenseTransactionsDao = userExpenseTransactionsDao;
    }

    @GetMapping("/{USERID}/{date}")
    ResponseEntity<Map<LocalDate, List<UserTransactions>>> getUserIncomeTransactions(@PathVariable int USERID, @PathVariable Date date) {
        List<UserTransactions> expenseTransactions = userExpenseTransactionsDao.getUserExpenseTransactions(USERID,date);
        List<UserTransactions> incomeTransactions = userIncomeTransactionsDao.getUserIncomeTransactions(USERID,date);

        List<UserTransactions> combinedList = Stream.concat(incomeTransactions.stream(), expenseTransactions.stream())
                .collect(Collectors.toList());

        Map<LocalDate, List<UserTransactions>> byDay = combinedList.stream()
                .collect(groupingBy(UserTransactions::getLOGDATE));

        return ResponseEntity.ok(new TreeMap<>(byDay).descendingMap());
    }
}
