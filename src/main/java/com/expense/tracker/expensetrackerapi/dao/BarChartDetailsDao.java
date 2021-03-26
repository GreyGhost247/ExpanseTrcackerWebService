package com.expense.tracker.expensetrackerapi.dao;

import com.expense.tracker.expensetrackerapi.entities.BarChartDetails;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.Date;
import java.util.List;

@Repository
public class BarChartDetailsDao {
    private final EntityManager entityManager;

    public BarChartDetailsDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<BarChartDetails> getIncomeChartDetails(int userId, Date date){
        StoredProcedureQuery getIncome = entityManager.createNamedStoredProcedureQuery("getIncomeChartDetailsSp")
                .setParameter("USERID",userId)
                .setParameter("SELECTED_DATE",date);
        return getIncome.getResultList();
    }
     public List<BarChartDetails> getExpenseChartDetails(int userId, Date date){
        StoredProcedureQuery getExpense = entityManager.createNamedStoredProcedureQuery("getExpenseChartDetailsSp")
                .setParameter("USERID",userId)
                .setParameter("SELECTED_DATE",date);
        return getExpense.getResultList();
    }
}
