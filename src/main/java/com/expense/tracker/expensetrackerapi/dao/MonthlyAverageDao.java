package com.expense.tracker.expensetrackerapi.dao;

import com.expense.tracker.expensetrackerapi.entities.MonthlyAverage;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.Date;
import java.util.List;

@Repository
public class MonthlyAverageDao {
    private final EntityManager entityManager;

    public MonthlyAverageDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
     public List<MonthlyAverage> getMonthlyAverage(int categoryId, Date date, int userId){
        StoredProcedureQuery getInsights = entityManager.createNamedStoredProcedureQuery("getMonthlyAverageSp")
                .setParameter("CategoryId",categoryId)
                .setParameter("SELECTED_MONTH",date)
                .setParameter("UserId",userId);
        return getInsights.getResultList();
    }
}
