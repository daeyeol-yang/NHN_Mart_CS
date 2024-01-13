package com.nhnacademy.springmvc.domain;

public class Customer extends User{

    private Customer(String id, String password, int age, String name) {
        super(id, password, age, name);
    }

    public static Customer create(String id, String password, int age, String name){
        return new Customer(id, password, age, name);
    }






}
