package com.study.springbootfastcampus.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //해당 Class는 REST API 처리하는 Controller라는 의미임
@RequestMapping("/api") //RequestMapping URI를 지정해주는 Annotation
public class ApiController {

    @GetMapping("/hello")   //http://localhost:9090/api/hello
    public String hello(){
        return "hello spring boot!";
    }
    @GetMapping("/get/hello")   // == @GetMapping(path ="/get/hello")
    public String getHello(){
        return "get hello";
    }
    /**
     예전에 자주 사용하던 방법
     @RequestMapping("/get/hi") - get, post, put, delete 모두 적용됨
     @RequestMapping(path = "/get/hi", method = RequestMethod.GET) - get만 지정하려면 method까지 상세 지정해주어야 함.
     => 이걸 합친 것이 @GetMapping이 됨
     */
    @RequestMapping(path = "/get/hi", method = RequestMethod.GET)
    public String hi(){
        return "hi";
    }
}
