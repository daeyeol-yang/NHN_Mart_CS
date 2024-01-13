package com.nhnacademy.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

public class Admin extends User{


    private Admin(String id, String password, int age, String name) {
        super(id, password, age, name);
    }

    public static Admin create(String id, String password, int age, String name){
        return new Admin(id, password, age, name);
    }
}
