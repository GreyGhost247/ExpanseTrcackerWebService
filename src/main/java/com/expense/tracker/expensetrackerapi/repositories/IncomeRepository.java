package com.expense.tracker.expensetrackerapi.repositories;

import com.expense.tracker.expensetrackerapi.entities.IncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface IncomeRepository extends JpaRepository<IncomeEntity, Integer> {
    @Query("Select SUM(inc.AMOUNT) from IncomeEntity inc where inc.USERID = ?1")
    Double getTotalIncomeOfAllTheTime(int userId);
    List<IncomeEntity> findAllByLOGDATEEqualsAndUSERIDEquals(Date LOGDATE, int USERID);

}
