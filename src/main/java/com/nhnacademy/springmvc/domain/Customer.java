package com.nhnacademy.springmvc.domain;

import com.nhnacademy.springmvc.domain.post.Post;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User{

    private Customer(String id, String password, int age, String name) {
        super(id, password, age, name);
    }

    private List<Post> posts = new ArrayList<>();
    public static Customer create(String id, String password, int age, String name){
        return new Customer(id, password, age, name);
    }






}
