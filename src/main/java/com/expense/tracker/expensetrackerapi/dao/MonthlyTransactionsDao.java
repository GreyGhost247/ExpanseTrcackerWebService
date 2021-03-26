package com.expense.tracker.expensetrackerapi.dao;

import com.expense.tracker.expensetrackerapi.entities.MonthlyTransactions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.Date;
import java.util.List;

@Repository
public class MonthlyTransactionsDao {
    private final EntityManager entityManager;

    public MonthlyTransactionsDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<MonthlyTransactions> getMonthlyIncomeTransactions(int userId, Date start, Date end){
        StoredProcedureQuery getIncome = entityManager.createNamedStoredProcedureQuery("getMonthlyIncomeSp")
                .setParameter("USERID",userId)
                .setParameter("START_DATE",start)
                .setParameter("END_DATE",end);
        return getIncome.getResultList();
    }
    public List<MonthlyTransactions> getMonthlyExpenseTransactions(int userId, Date start, Date end){
        StoredProcedureQuery getIncome = entityManager.createNamedStoredProcedureQuery("getMonthlyExpenseSp")
                .setParameter("USERID",userId)
                .setParameter("START_DATE",start)
                .setParameter("END_DATE",end);
        return getIncome.getResultList();
    }
}
