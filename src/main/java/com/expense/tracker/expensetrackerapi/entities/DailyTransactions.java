package com.expense.tracker.expensetrackerapi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;

@Entity
@Getter
@Setter
@AttributeOverride(name = "id", column = @Column(name = "ID"))
@NamedStoredProcedureQuery(name="getDailyIncomeSp",resultClasses = DailyTransactions.class,
        procedureName = "getDailySummedIncomeForCurrentMonth",parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "USERID", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "SELECTED_MONTH", type = Date.class)
})

@NamedStoredProcedureQuery(name="getDailyExpenseSp",resultClasses = DailyTransactions.class,
        procedureName = "getDailySummedExpenseForCurrentMonth",parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "USERID", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "SELECTED_MONTH", type = Date.class)
})

public class DailyTransactions extends IdentifiableModel{
    private double DAILY_TRANSACTION;
    private LocalDate LOG_DATE;
    private String T_TYPE;



    public static Comparator<DailyTransactions> DateComparator = new Comparator<DailyTransactions>() {

        @Override
        public int compare(DailyTransactions o1, DailyTransactions o2) {
            Integer day1 = o1.getLOG_DATE().getDayOfMonth();
            Integer day2 = o2.getLOG_DATE().getDayOfMonth();

            return  day1.compareTo(day2);
        }
    };
}
