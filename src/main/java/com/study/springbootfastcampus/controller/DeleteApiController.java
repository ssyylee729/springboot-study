package com.study.springbootfastcampus.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/delete")
public class DeleteApiController {

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable String userId, @RequestParam String account){
        System.out.println(userId);
        System.out.println(account);

        //이미 삭제되었어도 200 OK를 던진다.
        //멱등하다.
    }
}
