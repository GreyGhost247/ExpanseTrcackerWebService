package com.expense.tracker.expensetrackerapi.services;

import com.expense.tracker.expensetrackerapi.entities.CustomerEntity;
import com.expense.tracker.expensetrackerapi.principal.MyUserDetails;
import com.expense.tracker.expensetrackerapi.repositories.CustomerRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class MyUserDetailsService implements UserDetailsService {
    private final CustomerRepository customerRepository;

    public MyUserDetailsService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //provide implementation of UserDetails as it just an Interface.
        Optional<CustomerEntity> customerEntity = customerRepository.findCustomerEntityByEMAIL(s);
        customerEntity.orElseThrow(() -> new UsernameNotFoundException("User not found "+s));
        return customerEntity.map(MyUserDetails::new).get();
    }


}
