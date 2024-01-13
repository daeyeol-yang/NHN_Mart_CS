package com.nhnacademy.springmvc.repository.post;

import com.nhnacademy.springmvc.domain.post.Post;
import com.nhnacademy.springmvc.domain.post.PostCategory;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.stereotype.Repository;

@Repository("postRepository")
public class PostRepositoryImpl implements PostRepository {
    private final Map<Long, Post> posts = new HashMap<>();

    @Override
    public boolean exists(long id) {
        return posts.containsKey(id);
    }

    @Override
    public Post register(String title, PostCategory category, String content, Date date, String file) {
        long id = posts.keySet()
                .stream()
                .max(Comparator.comparing(Function.identity()))
                .map(l -> l + 1)
                .orElse(1L);


        Post post = Post.create(title, category, content, date, file);
        post.setId(id);

        posts.put(id,post);

        return post;
    }


    @Override
    public Post getPost(long id) {
        return exists(id) ? posts.get(id) : null;
    }

}
