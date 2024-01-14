package com.nhnacademy.springmvc.config;


import com.nhnacademy.springmvc.domain.post.PostCategory;
import com.nhnacademy.springmvc.repository.AdminRepository;
import com.nhnacademy.springmvc.repository.AdminRepositoryImpl;
import com.nhnacademy.springmvc.repository.Base;
import com.nhnacademy.springmvc.repository.CustomerRepository;
import com.nhnacademy.springmvc.repository.CustomerRepositoryImpl;
import com.nhnacademy.springmvc.repository.post.PostRepository;
import com.nhnacademy.springmvc.repository.post.PostRepositoryImpl;
import java.util.Date;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackageClasses = Base.class,excludeFilters = {@ComponentScan.Filter(Controller.class)} )
public class RootConfig {

    @Bean
    public CustomerRepository customerRepository(){
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        customerRepository.register("customer1","12345",26,"김영웅");
        customerRepository.register("9un.99","12345",26,"강 건");
        customerRepository.register("customer3","12345",26,"김성현");
        customerRepository.register("customer3","12345",27,"박승민");

        return customerRepository;
    }

    @Bean
    public AdminRepository adminRepository(){
        AdminRepository adminRepository = new AdminRepositoryImpl();
        adminRepository.register("admin","12345",27,"양대열");
        return adminRepository;
    }

    @Bean
    public PostRepository postRepository(){
        PostRepository postRepository = new PostRepositoryImpl();
        Date currentDate = new Date();
        postRepository.register("문제 1", PostCategory.COMPLAINT,"배달지연", currentDate,"file");
        return postRepository;
    }
}
