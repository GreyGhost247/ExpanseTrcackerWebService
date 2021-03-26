package com.expense.tracker.expensetrackerapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /**
     *
     * @param auth
     * @throws Exception
     * This configure method takes in an authentication builder and is responsible for handling authentication
     * In our case we wanna tell it to use jpa to fetch user instance and cross check with the details coming
     * through
     *
     * Keep in mind for JPA there is no out of box implementation for security, so you have to provide one.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       //this uses auth to ask userDetailsService that loads a user by username -> give it userDetailsService Instance
        auth.userDetailsService(userDetailsService);
    }

    //set up authorization, done through another configure method override that takes in HTTPSecurity

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors().and()
                .authorizeRequests()
                .antMatchers("api/customer/register","api/customer/login").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic();
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
