package com.expense.tracker.expensetrackerapi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter

@AttributeOverride(name = "id", column = @Column(name = "USERID"))
@NamedStoredProcedureQuery(name="getInsightSp",resultClasses = Insight.class,
        procedureName = "getInsight",parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "USERID", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "SELECTED_MONTH", type = Date.class)
})
public class Insight extends IdentifiableModel{
    private double TOTAL_AMOUNT;
    private String CATEGORY_NAME;
    private int CATEGORYID;
}
