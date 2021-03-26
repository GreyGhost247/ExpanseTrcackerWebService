package com.expense.tracker.expensetrackerapi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
@Table(name = "Expense")
@AttributeOverride(name = "id", column = @Column(name = "EXPENSEID"))
public class ExpenseEntity extends IdentifiableModel{
    private int USERID;
    private int CATEGORYID;
    private double AMOUNT;
    private Date LOGDATE;


}
