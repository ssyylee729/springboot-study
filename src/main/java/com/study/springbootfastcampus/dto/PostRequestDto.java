package com.study.springbootfastcampus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostRequestDto {
    private String account;
    private String email;
    private String address;
    @JsonProperty("phone_number") //api 전송 시에 phone_number 를 key로 보낼 때 매핑해줌
    private String phoneNumber;
}
