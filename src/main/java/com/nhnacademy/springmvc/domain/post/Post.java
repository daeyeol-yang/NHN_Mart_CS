package com.nhnacademy.springmvc.domain.post;

import com.nhnacademy.springmvc.domain.Admin;
import com.nhnacademy.springmvc.domain.Customer;
import java.util.Date;
import lombok.Setter;
import lombok.Value;


public class Post {


    @Setter
    private long id;

    private String title;
    private PostCategory category;

    private String content;

    private Date date;

    private boolean isAnswer;

    private String answerContent;

    private String file;

    private Customer customer;

    private Admin admin;

    public Post(String title, PostCategory category, String content, Date date, String file) {
        this.title =title;
        this.category=category;
        this.content=content;
        this.date=date;
        this.file=file;
    }


    public static Post create(String title, PostCategory category, String content, Date date, String file){
        return new Post(title, category, content, date, file);
    }
}
