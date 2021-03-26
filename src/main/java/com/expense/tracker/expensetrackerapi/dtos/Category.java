package com.expense.tracker.expensetrackerapi.dtos;

import com.expense.tracker.expensetrackerapi.entities.CategoryEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Category {

    private int categoryId;
    private String categoryName;
    private String instance;
    private Integer userId;

    public static Category fromEntity(CategoryEntity categoryEntity){
        Category category = new Category();
        category.setCategoryId(categoryEntity.getId());
        category.setCategoryName(categoryEntity.getCATEGORY_NAME());
        category.setUserId(categoryEntity.getUSERID());
        category.setInstance(categoryEntity.getInstance());
        return category;
    }
    @JsonIgnore
    public CategoryEntity toEntity(){
        CategoryEntity categoryEntity =  new CategoryEntity();
        categoryEntity.setCATEGORY_NAME(getCategoryName());
        categoryEntity.setUSERID(getUserId());
        categoryEntity.setInstance(getInstance());
        return  categoryEntity;
    }
}
