package com.nhnacademy.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

public abstract class User {

    @Getter
    private final String id;

    @Getter
    private final String password;

    @Getter
    @Setter
    private int age;

    @Getter
    @Setter
    private String name;

    protected User(String id, String password, int age , String name) {
        this.id = id;
        this.password = password;
        this.age=age;
        this.name=name;
    }
}
