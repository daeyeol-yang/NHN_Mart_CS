package com.nhnacademy.springmvc.config;


import com.nhnacademy.springmvc.repository.Base;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackageClasses = Base.class,excludeFilters = {@ComponentScan.Filter(Controller.class)} )
public class RootConfig {
}
