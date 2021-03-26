package com.expense.tracker.expensetrackerapi.dao;

import com.expense.tracker.expensetrackerapi.entities.YearlyAverage;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Repository
public class YearlyAverageDao {
    private final EntityManager entityManager;

    public YearlyAverageDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<YearlyAverage> getYearlyAverage(int categoryId,int userId){
        StoredProcedureQuery getInsights = entityManager.createNamedStoredProcedureQuery("getYearlyAverageSp")
                .setParameter("CategoryId",categoryId)
                .setParameter("UserId",userId);
        return getInsights.getResultList();
    }
}
