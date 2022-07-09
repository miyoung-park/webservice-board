package com.mi.board.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)    // 스프링 부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class)  // @Controller, @ControllerAdvice 등 사용 가능 @Service @Component @Repository 등은 불가능
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void returnHello() throws Exception {
        String hello = "hello";
        // GET Mapping 으로 /hello 통신
        mvc.perform(get("/hello"))
                .andExpect(status().isOk()) // HTTP 결과값 확인 (200... ok)
                .andExpect(content().string(hello)); //perform 의 결과값 검증
    }

    @Test
    public void returnHelloDto() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform( get("/hello/dto")
                    .param("name", name)
                    .param("amount", String.valueOf(amount))
                    )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) // jsonPath : JSON 응답값을 필드별로 검증할 수 있는 메소드
                .andExpect(jsonPath("$.amount" , is(amount)));

    }

}
