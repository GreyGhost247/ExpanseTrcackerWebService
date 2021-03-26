package com.expense.tracker.expensetrackerapi.repositories;

import com.expense.tracker.expensetrackerapi.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    @Query(value = "getExpenseDefinedCategories;", nativeQuery = true)
    List<CategoryEntity> getExpenseDefaultCategories();
    @Query(value = "getIncomeDefinedCategories;", nativeQuery = true)
    List<CategoryEntity> getIncomeDefaultCategories();

}
