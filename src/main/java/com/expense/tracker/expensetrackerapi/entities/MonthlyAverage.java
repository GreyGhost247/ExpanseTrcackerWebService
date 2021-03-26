package com.expense.tracker.expensetrackerapi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter

@AttributeOverride(name = "id", column = @Column(name = "CATEGORYID"))
@NamedStoredProcedureQuery(name="getMonthlyAverageSp",resultClasses = MonthlyAverage.class,
        procedureName = "getAverageOfExpensiveExpensePerMonth",parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "CategoryId", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "SELECTED_MONTH", type = Date.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "UserId", type = Integer.class)
})
public class MonthlyAverage extends IdentifiableModel{
   private double AVERAGE_SPENDING_PER_MONTH;
   private int AMONTH;
}
