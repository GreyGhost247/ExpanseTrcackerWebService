package com.expense.tracker.expensetrackerapi.dtos;

import com.expense.tracker.expensetrackerapi.entities.IncomeEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
@Getter
@Setter

public class Income {

    private int incomeId;
    private int userId;
    private int categoryId;
    private double amount;
    private Date logDate;


    @JsonIgnore
    public IncomeEntity toEntity(){
        IncomeEntity incomeEntity = new IncomeEntity();
        incomeEntity.setUSERID(getUserId());
        incomeEntity.setCATEGORYID(getCategoryId());
        incomeEntity.setAMOUNT(getAmount());
        incomeEntity.setLOGDATE(getLogDate());
        return incomeEntity;
    }

    public static Income fromEntity(IncomeEntity incomeEntity){
        Income income = new Income();
        income.setIncomeId(incomeEntity.getId());
        income.setUserId(incomeEntity.getUSERID());
        income.setCategoryId(incomeEntity.getCATEGORYID());
        income.setAmount(incomeEntity.getAMOUNT());
        income.setLogDate(incomeEntity.getLOGDATE());
        return income;
    }

}
