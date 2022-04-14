package com.study.springbootfastcampus.controller;

import com.study.springbootfastcampus.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping("/hello")   // == @GetMapping(path ="/get/hello")
    public String getHello(){
        return "get hello";
    }
    /**
     예전에 자주 사용하던 방법
     @RequestMapping("/get/hi") - get, post, put, delete 모두 적용됨
     @RequestMapping(path = "/get/hi", method = RequestMethod.GET) - get만 지정하려면 method까지 상세 지정해주어야 함.
     => 이걸 합친 것이 @GetMapping이 됨
     */
    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public String hi(){
        return "hi";
    }

    /**
     http://localhost:9090/api/get/path-variable/{name}
     만약 변수명을 name으로 하지 못하는 경우,
     (@PathVariable(name = "name") String pathName) 이런 식으로 name 속성에 path variable을 지정해주면 됨.
     */
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name){
        System.out.println("PathVariable: "+ name);

        return name;

    }

    /**
     Query Parameter
     검색할 때의 여러 매개변수 인자 ?로 시작하고 & 연산자로 연결
     => ?key=value&key2=value2 .... 이런 형식으로!

     ex. google에서 intellij 검색 시
     https://www.google.com/
     search?q=intellij
     &oq=intellij
     &aqs=chrome..69i57j35i39l2j0i20i263i512j0i512l3j0i433i512j0i512j0i131i433i512.1502j0j7
     &sourceid=chrome
     &ie=UTF-8


     ex. http://localhost:9090/api/get/query-param?user=kelly&email=kelly@gmail.com&age=28
     */

    @GetMapping(path = "/query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){
        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+"="+ entry.getValue()+"\n");
        });
        return sb.toString();
    }


    /**
     명시적으로 queryParam 지정할 때 아래와 같이 각각 @Requestparam 지정
     */
    @GetMapping(path = "/query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    )
    {
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name +" "+ email+" "+age;
    }

    /**
     변수가 여러 개인 경우, 하나하나 적어주기가 귀찮아진다.
     dto를 이용하여 한꺼번에 받으면 된다. 이때는 @RequestParam을 적지 않는다.
     */
    @GetMapping(path = "/query-param03")
    public String queryParam03(UserRequest userRequest){

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
