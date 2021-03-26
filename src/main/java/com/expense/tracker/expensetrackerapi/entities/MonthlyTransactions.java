package com.expense.tracker.expensetrackerapi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AttributeOverride(name = "id", column = @Column(name = "ID"))
@NamedStoredProcedureQuery(name="getMonthlyIncomeSp",resultClasses = MonthlyTransactions.class,
        procedureName = "getMonthlyIncomeTransactions",parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "USERID", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "START_DATE", type = Date.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "END_DATE", type = Date.class)
})
@NamedStoredProcedureQuery(name="getMonthlyExpenseSp",resultClasses = MonthlyTransactions.class,
        procedureName = "getMonthlyExpenseTransactions",parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "USERID", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "START_DATE", type = Date.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "END_DATE", type = Date.class)
})
public class MonthlyTransactions extends IdentifiableModel{
    private double AMOUNT;
    private  int MN;
    private LocalDate YR;
    private String CATEGORY;
}
