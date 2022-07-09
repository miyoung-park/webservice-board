package com.mi.board.web;

import com.mi.board.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// JSON 을 반환하는 컨트롤러 생성( @Controller + @ResponseBody )
// Restful API 를 만들 때 사용하는 특수 컨트롤러
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto( @RequestParam("name") String name,
                                      @RequestParam("amount") int amount ){

        return new HelloResponseDto( name , amount );
    }
}
