package com.expense.tracker.expensetrackerapi.dao;

import com.expense.tracker.expensetrackerapi.entities.CategoryEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Repository
public class CategoryDao {
    private final EntityManager entityManager;

    public CategoryDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<CategoryEntity> getUserDefinedIncomeCategories(int userId) {
        StoredProcedureQuery getTransactions = entityManager.createNamedStoredProcedureQuery("userDefinedIncomeCategoriesSp")
                .setParameter("USERID",userId);
        return getTransactions.getResultList();
    }

    public List<CategoryEntity> getUserDefinedExpenseCategories(int userId) {
        StoredProcedureQuery getTransactions = entityManager.createNamedStoredProcedureQuery("userDefinedExpenseCategoriesSp")
                .setParameter("USERID",userId);
        return getTransactions.getResultList();
    }
}
