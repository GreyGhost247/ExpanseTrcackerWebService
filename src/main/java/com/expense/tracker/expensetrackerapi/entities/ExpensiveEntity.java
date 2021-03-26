package com.expense.tracker.expensetrackerapi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter

@AttributeOverride(name = "id", column = @Column(name = "CATEGORYID"))
@NamedStoredProcedureQuery(name="getTopFiveCurrentMonthSp",resultClasses = ExpensiveEntity.class,
        procedureName = "getTopFiveExpensesForCurrentMonth",parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "USERID", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "SELECTED_MONTH", type = Date.class)

})
@NamedStoredProcedureQuery(name="getTopFiveAllSp",resultClasses = ExpensiveEntity.class,
        procedureName = "getTopFiveExpensesOfAllTTheTime",parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "USERID", type = Integer.class)

})

public class ExpensiveEntity extends IdentifiableModel{
    private String CATEGORY_NAME;
    private double AMOUNT;
}
