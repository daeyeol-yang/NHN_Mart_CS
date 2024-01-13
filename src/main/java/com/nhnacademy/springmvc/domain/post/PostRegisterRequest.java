package com.nhnacademy.springmvc.domain.post;

import com.nhnacademy.springmvc.domain.Customer;
import java.io.File;
import java.util.Date;
import lombok.Value;

@Value
public class PostRegisterRequest {
    private Long id;

    private String title;

    private PostCategory category;

    private String content;

    private Date date;

    private String file;

    private Customer customer;

}
