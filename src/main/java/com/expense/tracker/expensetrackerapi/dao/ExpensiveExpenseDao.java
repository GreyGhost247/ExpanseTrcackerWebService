package com.expense.tracker.expensetrackerapi.dao;

import com.expense.tracker.expensetrackerapi.entities.ExpensiveEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.Date;
import java.util.List;

@Repository
public class ExpensiveExpenseDao {
    private final EntityManager entityManager;

    public ExpensiveExpenseDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<ExpensiveEntity> getTopFiveMonthly(int userId, Date date){
        StoredProcedureQuery getExpenses = entityManager.createNamedStoredProcedureQuery("getTopFiveCurrentMonthSp")
                .setParameter("USERID",userId)
                .setParameter("SELECTED_MONTH",date);
        return getExpenses.getResultList();
    }
    public List<ExpensiveEntity> getTopFiveAllTheTime(int userId){
        StoredProcedureQuery getExpenses = entityManager.createNamedStoredProcedureQuery("getTopFiveAllSp")
                .setParameter("USERID",userId);
        return getExpenses.getResultList();
    }
}
