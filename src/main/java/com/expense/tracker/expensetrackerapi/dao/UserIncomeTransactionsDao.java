package com.expense.tracker.expensetrackerapi.dao;


import com.expense.tracker.expensetrackerapi.entities.UserTransactions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.Date;
import java.util.List;
@Repository
public class UserIncomeTransactionsDao {
    private final EntityManager entityManager;

    public UserIncomeTransactionsDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<UserTransactions> getUserIncomeTransactions(int userId, Date date) {
        StoredProcedureQuery getTransactions = entityManager.createNamedStoredProcedureQuery("UserIncomeTransactions")
                .setParameter("USERID",userId)
                .setParameter("SELECTED_MONTH",date);
        return getTransactions.getResultList();
    }
}
