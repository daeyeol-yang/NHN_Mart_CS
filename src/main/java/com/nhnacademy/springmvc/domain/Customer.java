package com.nhnacademy.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

public class Customer extends User{


    @Getter
    @Setter
    private int age;


    @Getter
    @Setter
    private String group;

    @Getter
    private final boolean ADMIN =false;

    public Customer(String id, String password, String name, int age, String group) {
        super(id, password, name);
        this.age = age;
        this.group = group;
    }
}
