package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Customer;
import com.nhnacademy.springmvc.domain.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CustomerRepositoryImpl implements CustomerRepository {
    
    private final Map<String, Customer> customerMap = new HashMap<>();

    @Override
    public boolean exists(String id) {
        return customerMap.containsKey(id);
    }

    @Override
    public boolean matches(String id, String password) {
        return Optional.ofNullable(getUser(id))
                .map(Customer -> Customer.getPassword().equals(password))
                .orElse(false);
    }


    @Override
    public User getUser(String id) {
        return exists(id) ? customerMap.get(id):null;

    }
}
