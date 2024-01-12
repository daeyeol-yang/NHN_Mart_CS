package com.nhnacademy.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

public class Admin extends User{



    @Getter
    private final boolean ADMIN =true;

    public Admin(String id, String password, String name) {
        super(id, password, name);
    }
}
