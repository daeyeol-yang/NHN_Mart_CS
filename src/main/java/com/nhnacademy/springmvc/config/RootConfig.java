package com.nhnacademy.springmvc.config;


import com.nhnacademy.springmvc.repository.Base;
import com.nhnacademy.springmvc.repository.CustomerRepository;
import com.nhnacademy.springmvc.repository.CustomerRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackageClasses = Base.class,excludeFilters = {@ComponentScan.Filter(Controller.class)} )
public class RootConfig {

    @Bean
    public CustomerRepository userRepository(){
        CustomerRepository userRepository = new CustomerRepositoryImpl();

        return userRepository;
    }
}
