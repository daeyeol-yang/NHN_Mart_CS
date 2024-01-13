package com.nhnacademy.springmvc.repository.post;

import com.nhnacademy.springmvc.domain.post.Post;
import com.nhnacademy.springmvc.domain.post.PostCategory;
import java.util.Date;


public interface PostRepository {

    boolean exists(long id);

    Post register(String title, PostCategory category, String content, Date date, String file );

    Post getPost(long id);
}


