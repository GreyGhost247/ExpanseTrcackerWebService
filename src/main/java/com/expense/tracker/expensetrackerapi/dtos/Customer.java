package com.expense.tracker.expensetrackerapi.dtos;

import com.expense.tracker.expensetrackerapi.entities.CustomerEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class Customer {

    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date dateRegistered;
    private Date lastLoginDate;

    public Customer() {
    }

    @JsonIgnore
    public CustomerEntity toEntity() {
        CustomerEntity user = new CustomerEntity();
        user.setFIRST_NAME(getFirstName());
        user.setLAST_NAME(getLastName());
        user.setEMAIL(getEmail());
        user.setPASSWORD(getPassword());
        user.setDATE_REGISTERED(getDateRegistered());
        user.setLAST_LOGIN_DATE(getLastLoginDate());
        return user;
    }

    public static Customer fromEntity(CustomerEntity userEntity) {
        Customer user = new Customer();
        user.setUserId(userEntity.getId());
        user.setFirstName(userEntity.getFIRST_NAME());
        user.setLastName(userEntity.getLAST_NAME());
        user.setEmail(userEntity.getEMAIL());
        user.setPassword(userEntity.getPASSWORD());
        user.setDateRegistered(userEntity.getDATE_REGISTERED());
        user.setLastLoginDate(userEntity.getLAST_LOGIN_DATE());
        return user;
    }
}
