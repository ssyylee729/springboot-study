package com.study.springbootfastcampus.controller;

import com.study.springbootfastcampus.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController //해당 Class는 REST API 처리하는 Controller라는 의미임
@RequestMapping("/api") //RequestMapping URI를 지정해주는 Annotation
public class ApiController {

    @GetMapping("/hello")   //http://localhost:9090/api/hello
    public String hello(){
        return "hello spring boot!";
    }

}
