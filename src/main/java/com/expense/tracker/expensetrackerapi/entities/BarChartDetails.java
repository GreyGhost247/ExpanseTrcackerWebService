package com.expense.tracker.expensetrackerapi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AttributeOverride(name = "id", column = @Column(name = "ID"))
@NamedStoredProcedureQuery(name="getIncomeChartDetailsSp",resultClasses = BarChartDetails.class,
        procedureName = "getIncomeBarChartDetails",parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "USERID", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "SELECTED_DATE", type = Date.class)
})
@NamedStoredProcedureQuery(name="getExpenseChartDetailsSp",resultClasses = BarChartDetails.class,
        procedureName = "getExpenseBarChartDetails",parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "USERID", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "SELECTED_DATE", type = Date.class)
})
public class BarChartDetails extends IdentifiableModel{
    private double AMOUNT;
    private String CATEGORY_NAME;
    private Date LOGDATE;
}
