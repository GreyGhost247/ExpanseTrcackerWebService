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
@NamedStoredProcedureQuery(name="UserIncomeTransactions",resultClasses = UserTransactions.class,
        procedureName = "getUserIncomeTransactions",parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "USERID", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "SELECTED_MONTH", type = Date.class)
})
@NamedStoredProcedureQuery(name="UserExpenseTransactions",resultClasses = UserTransactions.class,
        procedureName = "getUserExpenseTransactions",parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "USERID", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "SELECTED_MONTH", type = Date.class)
})
public class UserTransactions extends IdentifiableModel{
    private double AMOUNT;
    private String CATEGORY_NAME;
    private LocalDate LOGDATE;
    private String T_TYPE;
}
