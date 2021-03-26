package com.expense.tracker.expensetrackerapi.controllers;

import com.expense.tracker.expensetrackerapi.dtos.Customer;
import com.expense.tracker.expensetrackerapi.entities.CustomerEntity;
import com.expense.tracker.expensetrackerapi.exceptions.ConflictException;
import com.expense.tracker.expensetrackerapi.exceptions.MyResourceNotFoundException;
import com.expense.tracker.expensetrackerapi.repositories.CustomerRepository;
import com.expense.tracker.expensetrackerapi.repositories.ExpenseRepository;
import com.expense.tracker.expensetrackerapi.repositories.IncomeRepository;
import com.expense.tracker.expensetrackerapi.util.RestPreconditions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/customer")
@CrossOrigin
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;

    public CustomerController(CustomerRepository customerRepository, IncomeRepository incomeRepository, ExpenseRepository expenseRepository) {
        this.customerRepository = customerRepository;
        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
    }

    @PostMapping("/login")
   Customer login(@RequestBody Customer customer, HttpServletResponse response) {
        try{

            CustomerEntity getCustomer = RestPreconditions.checkFound(customerRepository.findCustomerEntityByEMAILAndPASSWORD(
                    customer.getEmail(),customer.getPassword()
            ));

            return Customer.fromEntity(getCustomer);
        }
        catch (MyResourceNotFoundException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Bad credentials", exc);
        }

    }

    @GetMapping("/{id}")
    ResponseEntity<Customer> getUser(@PathVariable int id){
       return ResponseEntity.ok(Customer.fromEntity(customerRepository.findCustomerEntityById(id)));
    }

    @PostMapping("/register")
    Customer newUser(@RequestBody Customer customer, HttpServletResponse response){
        Date currentDate = new Date();
        customer.setDateRegistered(currentDate);
        customer.setLastLoginDate(currentDate);
        try {
           Optional<CustomerEntity> customerEntity = customerRepository.findCustomerEntityByEMAIL(customer.getEmail());
           RestPreconditions.checkExist(customerEntity.isPresent());
           return Customer.fromEntity(customerRepository.save(customer.toEntity()));
        }catch (ConflictException ce){
            throw new
                    ResponseStatusException(HttpStatus.CONFLICT,"Already exist", ce);
        }

    }
    @GetMapping
    ResponseEntity<List<Customer>> getAll(){
        List<CustomerEntity> customerEntityList = customerRepository.findAll();
        List<Customer> customers = new ArrayList<>();
        customerEntityList.forEach(customerEntity -> customers.add(Customer.fromEntity(customerEntity)));

        return ResponseEntity.ok(customers);
    }

    @GetMapping("/balance/{userId}")
    ResponseEntity<Double> getCurrentBalanceOfAllTheTime(@PathVariable int userId){
        Double totalIncome = incomeRepository.getTotalIncomeOfAllTheTime(userId);
        Double totalExpense = expenseRepository.getTotalExpensesOfAllTheTime(userId);
       
        if(totalExpense == null && totalIncome == null)
            return ResponseEntity.ok((double) 0);
        else if(totalExpense == null)
            return ResponseEntity.ok(totalIncome);
        else if(totalIncome == null)
            return ResponseEntity.ok(totalExpense);
        else
            return ResponseEntity.ok(totalIncome - totalExpense);

    }

}
