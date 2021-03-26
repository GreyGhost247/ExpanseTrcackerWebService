package com.expense.tracker.expensetrackerapi.repositories;

import com.expense.tracker.expensetrackerapi.dtos.Customer;
import com.expense.tracker.expensetrackerapi.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    CustomerEntity findCustomerEntityById(int id);
    Optional<CustomerEntity> findCustomerEntityByEMAIL(String email);

    CustomerEntity findCustomerEntityByEMAILAndPASSWORD(String email, String Password);
}
