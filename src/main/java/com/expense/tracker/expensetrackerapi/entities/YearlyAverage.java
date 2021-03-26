package com.expense.tracker.expensetrackerapi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter

@AttributeOverride(name = "id", column = @Column(name = "CATEGORYID"))
@NamedStoredProcedureQuery(name="getYearlyAverageSp",resultClasses = YearlyAverage.class,
        procedureName = "getAverageOfExpensiveExpense",parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "CategoryId", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "UserId", type = Integer.class)

})
public class YearlyAverage extends IdentifiableModel{
    private double AVERAGE_SPENDING;
    private int AYEAR;
}
