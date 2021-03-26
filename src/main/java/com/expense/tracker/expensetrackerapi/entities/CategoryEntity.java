package com.expense.tracker.expensetrackerapi.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "Category")
@AttributeOverride(name = "id", column = @Column(name = "CATEGORYID"))
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name="userDefinedIncomeCategoriesSp",resultClasses = CategoryEntity.class,
        procedureName = "getUserDefinedIncomeCategories",parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "USERID", type = Integer.class)
}), @NamedStoredProcedureQuery(name="userDefinedExpenseCategoriesSp",resultClasses = CategoryEntity.class,
        procedureName = "getUserDefinedExpenseCategories",parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN,name = "USERID", type = Integer.class)
})})

public class CategoryEntity extends IdentifiableModel {

    @Column
    private String CATEGORY_NAME;
    @Column
    private String Instance;
    @Column
    private Integer USERID;
   /* @OneToMany(targetEntity = ExpenseEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORYID", referencedColumnName = "CATEGORYID")
    private List<ExpenseEntity> expenseEntityList;
    @OneToMany(targetEntity = IncomeEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORYID", referencedColumnName = "CATEGORYID")
    private List<IncomeEntity> incomeEntityList;*/
}
