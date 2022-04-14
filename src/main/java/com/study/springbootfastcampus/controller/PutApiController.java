package com.study.springbootfastcampus.controller;

import com.study.springbootfastcampus.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/put")
public class PutApiController {

    @PutMapping
    public PutRequestDto put(@RequestBody PutRequestDto putRequestDto){
        System.out.println(putRequestDto);

        //Object 자체를 response로 내릴 시 Springboot에서 자동으로 object mapping하여 처리해줌
        //Object class에 naming rule 있을 시 적용되어 response 내려줌
        return putRequestDto;

    }
    @PutMapping("/{userId}")
    public PutRequestDto put(@RequestBody PutRequestDto putRequestDto, @PathVariable(name = "userId") Long id){
        System.out.println(putRequestDto);
        System.out.println(id);

        return putRequestDto;

    }

}
