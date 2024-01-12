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
    private String name;

    public User(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

}
