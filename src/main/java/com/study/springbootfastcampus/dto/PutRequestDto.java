package com.study.springbootfastcampus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
/**
 각각 @JsonProperty로 지정해주어도 되지만,
 클래스 전체에 @JsonNaming으로 일괄 지정이 가능하다*/
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PutRequestDto {

    private String name;
    private int age;
//    @JsonProperty("car_list")
    private List<CarDto> carList;

}
