package com.expense.tracker.expensetrackerapi.dao;

import com.expense.tracker.expensetrackerapi.entities.DailyTransactions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.Date;
import java.util.List;

@Repository
public class DailyTransactionsDao {
    private final EntityManager entityManager;

    public DailyTransactionsDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<DailyTransactions> getDailyIncomeSummed(int userId, Date date){
        StoredProcedureQuery getIncome = entityManager.createNamedStoredProcedureQuery("getDailyIncomeSp")
                .setParameter("USERID",userId)
                .setParameter("SELECTED_MONTH",date);
        return getIncome.getResultList();
    }
    public List<DailyTransactions> getDailyExpenseSummed(int userId, Date date){
        StoredProcedureQuery getIncome = entityManager.createNamedStoredProcedureQuery("getDailyExpenseSp")
                .setParameter("USERID",userId)
                .setParameter("SELECTED_MONTH",date);
        return getIncome.getResultList();
    }


}
