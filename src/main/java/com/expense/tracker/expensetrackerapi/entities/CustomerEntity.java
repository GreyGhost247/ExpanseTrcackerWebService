package com.expense.tracker.expensetrackerapi.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Customer")
@AttributeOverride(name = "id", column = @Column(name = "USERID"))
@Getter
@Setter

public class CustomerEntity extends IdentifiableModel{
    
    private String FIRST_NAME;
    private String LAST_NAME;
    private String EMAIL;
    private String PASSWORD;
    private Date DATE_REGISTERED;
    private Date LAST_LOGIN_DATE;
    /*@OneToMany(targetEntity = CategoryEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    private List<CategoryEntity> categoryEntityList;*/

}
