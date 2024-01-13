package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.post.Post;
import com.nhnacademy.springmvc.domain.post.PostRegisterRequest;
import com.nhnacademy.springmvc.repository.post.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/post/register")
public class PostRegisterController {

    private final PostRepository postRepository;

    public PostRegisterController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public String postRegisterForm(){
        return "postRegisterForm";
    }

    @PostMapping
    public ModelAndView postRegisterPost(@ModelAttribute PostRegisterRequest postRegisterRequest, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
        }

        Post post = postRepository.register(postRegisterRequest.getTitle(),postRegisterRequest.getCategory(),postRegisterRequest.getContent(),postRegisterRequest.getDate(),postRegisterRequest.getFile());

        ModelAndView mav = new ModelAndView("customerMain");
        //todo viewname 입력

        mav.addObject("postRegister", post);

        return mav;


    }


}
