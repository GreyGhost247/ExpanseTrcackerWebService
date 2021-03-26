package com.expense.tracker.expensetrackerapi.controllers;

import com.expense.tracker.expensetrackerapi.dao.CategoryDao;
import com.expense.tracker.expensetrackerapi.dtos.Category;
import com.expense.tracker.expensetrackerapi.entities.CategoryEntity;
import com.expense.tracker.expensetrackerapi.repositories.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {
    private final CategoryRepository categoryRepository;
    private final CategoryDao categoryDao;

    public CategoryController(CategoryRepository categoryRepository, CategoryDao categoryDao) {
        this.categoryRepository = categoryRepository;
        this.categoryDao = categoryDao;
    }

    @GetMapping
    ResponseEntity<List<Category>> getAll() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        List<Category> categoryList = new ArrayList<>();
        categoryEntityList.forEach(categoryEntity -> categoryList.add(Category.fromEntity(categoryEntity)));
        return ResponseEntity.ok(categoryList);

    }

    @GetMapping("/e/default")
    ResponseEntity<List<Category>> getExpenseDefaultCategories() {
        List<CategoryEntity> categoryEntityList = categoryRepository.getExpenseDefaultCategories();
        List<Category> categoryList = new ArrayList<>();
        categoryEntityList.forEach(categoryEntity -> categoryList.add(Category.fromEntity(categoryEntity)));
        return ResponseEntity.ok(categoryList);

    }


    @GetMapping("/i/{USERID}")
    ResponseEntity<List<CategoryEntity>> getUserDefinedIncomeCategories(@PathVariable int USERID) {

        return ResponseEntity.ok(categoryDao.getUserDefinedIncomeCategories(USERID));

    }

    @GetMapping("/e/{USERID}")
    ResponseEntity<List<CategoryEntity>> getUserDefinedExpenseCategories(@PathVariable int USERID) {

        return ResponseEntity.ok(categoryDao.getUserDefinedExpenseCategories(USERID));

    }

    @GetMapping("/i/default")
    ResponseEntity<List<Category>> getIncomeDefaultCategories() {
        List<CategoryEntity> categoryEntityList = categoryRepository.getIncomeDefaultCategories();
        List<Category> categoryList = new ArrayList<>();
        categoryEntityList.forEach(categoryEntity -> categoryList.add(Category.fromEntity(categoryEntity)));
        return ResponseEntity.ok(categoryList);

    }

    @PostMapping("/add")
    ResponseEntity<Category> newCategory(@RequestBody Category category) {
        Category toReturn = Category.fromEntity(categoryRepository.save(category.toEntity()));
        return ResponseEntity.ok(toReturn);
    }
}
