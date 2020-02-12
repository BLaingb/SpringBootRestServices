package com.natgas.courses.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    // GET
    // /hello-world
    // method Hello World
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }
    
    @GetMapping(path = "/bean")
    public HelloWorldBean bean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/bean/{name}")
    public HelloWorldBean beanName(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello, %s", name));
    }

}