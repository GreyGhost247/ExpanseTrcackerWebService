package com.expense.tracker.expensetrackerapi.dao;

import com.expense.tracker.expensetrackerapi.entities.Insight;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.Date;
import java.util.List;

@Repository
public class InsightDao {
    private final EntityManager entityManager;

    public InsightDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

   public List<Insight> getInsight(int userId, Date date){
        StoredProcedureQuery getInsights = entityManager.createNamedStoredProcedureQuery("getInsightSp")
                .setParameter("USERID",userId)
                .setParameter("SELECTED_MONTH",date);
        return getInsights.getResultList();
    }
}
